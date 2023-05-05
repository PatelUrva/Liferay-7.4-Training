package com.aixtor.training.user.customfield.portlet;

/**
 * @author Urva Patel
 */

import com.aixtor.training.user.customfield.constants.UserHobbyPortletKeys;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UserHobby",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UserHobbyPortletKeys.USERHOBBY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserHobbyPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		
		String value = "";
		
		// 1. Using ThemeDisplay getting current logged in user details
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long companyId = themeDisplay.getCompanyId();
		
		// 2. Custom field name to be fetched
		String columnName = "Hobby";
		
		ExpandoTable expandoTable;
		try {
			
			// 3. Getting classNameId based of logged in user group
			Group group = GroupLocalServiceUtil.getUserGroup(companyId, userId);
			long classNameId = group.getClassNameId();
			
			// 4. Getting table details from companyId and classNameId
			expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, classNameId);
			long tableId = expandoTable.getTableId();
			
			// 5. Getting column details from tableId fetched and columnName to be fetched
			ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(tableId, columnName);
			long columnId = expandoColumn.getColumnId();
			
			// 6. Check if column details is null or not : If not null then get ColumnValue of Hobby Column
			if(Validator.isNotNull(expandoColumn)) {
				ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(tableId, columnId, userId);
				
				// 7. If columnValue is not null get data from the value
				if (Validator.isNotNull(expandoValue)) {
					value = expandoValue.getData();
				}
			}
		} catch (PortalException e1) {
			
			// 8. If table is null or the table not exists with the classNameId provided
			System.out.println("UserHobbyPortlet >>> Error Occured: " + e1.getMessage() + "\n");
		}
		
		request.setAttribute("hobby", value);
		super.render(request, response);
	}
	
}