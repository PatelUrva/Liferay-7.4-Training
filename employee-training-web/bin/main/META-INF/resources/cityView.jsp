<%@page import="com.aixtor.training.service.CityLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.CityLocalService"%>
<%@page import="com.aixtor.training.model.City"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addCityRenderURL">
    <portlet:param name="action" value="add"/>
    <portlet:param name="redirectURL" value="<%=currentURL %>"/>
</portlet:renderURL>


<div class="mb-5">
    <a href="${addCityRenderURL}" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"> Add City </i>
    </a>
</div>

<%
 List<City> cityList = CityLocalServiceUtil.getCities(-1,-1);
 System.out.println(cityList.size());
%>

<liferay-ui:search-container 
	total="${cityList.size()}" 
	var="searchContainer" 
	delta="5" 
	deltaConfigurable="false" 
  	emptyResultsMessage="Oops. There Are No Cities To Display, Please add City">
  
	 <liferay-ui:search-container-results results="<%= ListUtil.subList(cityList, searchContainer.getStart(),searchContainer.getEnd())%>" />	
		  <liferay-ui:search-container-row className="com.aixtor.training.model.City" modelVar="city" keyProperty="cityId" >
			  
			  <liferay-portlet:renderURL var="editCity">
			  		<portlet:param name="action" value="edit"/>
			  		<portlet:param name="cityId" value="${String.valueOf(city.getCityId())}" />
			  		<portlet:param name="redirectURL" value="${currentURL}"/>
			  </liferay-portlet:renderURL>
			  
			  
			  <liferay-portlet:actionURL name="deleteCity" var="deleteCityActionURL">
			  		<portlet:param name="cityId" value="${String.valueOf(city.getCityId())}" />
			  </liferay-portlet:actionURL>
			  
			   <liferay-ui:search-container-column-text name="City Name" property="cityName"/>
			   <liferay-ui:search-container-column-text name="State Id" property="stateId"/>
		 	   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editCity}">Edit</a> &nbsp;
		 	   		<a href="${deleteCityActionURL}">Delete</a>
		 	   		
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>