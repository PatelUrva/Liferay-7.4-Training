<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="userhobby.caption"/></b>
</p>


Hobby :- <%= request.getAttribute("hobby") %>