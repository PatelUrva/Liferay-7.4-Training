<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%@page import="com.aixtor.training.service.BranchLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.BranchLocalService"%>
<%@page import="com.aixtor.training.model.Branch"%>

<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm"%>

<%@page import="com.aixtor.training.service.CityLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.CityLocalService"%>
<%@page import="com.aixtor.training.model.City"%>

<%@page import="com.aixtor.training.service.DepartmentLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.DepartmentLocalService"%>
<%@page import="com.aixtor.training.model.Department"%>

<%@page import="com.aixtor.training.service.DesignationLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.DesignationLocalService"%>
<%@page import="com.aixtor.training.model.Designation"%>

<%@page import="com.aixtor.training.service.EmployeeLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.EmployeeLocalService"%>
<%@page import="com.aixtor.training.model.Employee"%>

<%@page import="com.aixtor.training.service.StateLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.StateLocalService"%>
<%@page import="com.aixtor.training.model.State"%>

<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">


<liferay-theme:defineObjects />

<portlet:defineObjects />