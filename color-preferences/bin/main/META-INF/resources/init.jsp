<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.aixtor.portal.color.preference.ColorConfiguration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    ColorConfiguration colorConfiguration = (ColorConfiguration) renderRequest
            .getAttribute(ColorConfiguration.class.getName());

	
    String color = StringPool.BLANK;
    
 
   if (Validator.isNotNull(colorConfiguration)) {
      color = portletPreferences.getValue("color", colorConfiguration.color());
       
   }
    
   
%>