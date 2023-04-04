<%@ include file="init.jsp" %>

<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addCityRenderURL">
    <portlet:param name="action" value="add"/>
    <portlet:param name="redirectURL" value="<%=currentURL %>"/>
</portlet:renderURL>


<div class="mb-5">
    <a href="${addCityRenderURL}" class="btn  btn-primary btn-default">
      <i class="fa-solid fa-plus"></i> Add City 
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
	deltaConfigurable="true" 
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
		 	   		<a  href="${editCity}"> 
		 	   			<i class="fa-solid fa-pen-to-square"></i>
		 	   		</a>&nbsp;
		 	   		<a href="${deleteCityActionURL}"> 
		 	   			<i class="fa-solid fa-trash"></i>
		 	   		</a>
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>