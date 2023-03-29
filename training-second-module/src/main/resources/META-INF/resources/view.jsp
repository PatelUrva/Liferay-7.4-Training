<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
table {
  border-collapse: collapse;
  width: 100%;
  border:1px solid #f2f2f2;
}

th, td {
  text-align: left;
  padding: 8px;
}


th {
  background-color: #f2f2f2;
  font-style:bold;
}
</style>

<table>
	<center> <h3> Employee List </h3> </center>
	<tr>
		<th> ID </th>
		<th> Name </th>
		<th> Enrollment Number </th>
		<th> Subject </th>
	</tr>
	<tbody>
		<c:forEach var="emp" items="${employeeList}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.enrollmentNo}</td>
                <td>${emp.subject}</td>
            </tr>
        </c:forEach>
	</tbody>
</table>

<p>
	<b><liferay-ui:message key="lifecyclecomponent.caption"/></b>
</p>