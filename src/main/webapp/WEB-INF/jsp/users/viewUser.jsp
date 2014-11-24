<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="home" value="/" />
<c:url var="createUserUrl" value="/users/createUserForm" />
<c:url var="listUsersUrl" value="/users/listUsers" />
<html>
<body>
	<table border="1">
		<tr>
			<td><spring:message code="user.id" /></td>
			<td><spring:message code="user.username" /></td>
			<td><spring:message code="user.name" /></td>
			<td><spring:message code="general.createDate" /></td>
			<td><spring:message code="general.updateDate" /></td>
		</tr>
		<tr>
			<td><c:out value="${user.id}" /></td>
			<td><c:out value="${user.username}" /></td>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.createDate}" /></td>
			<td><c:out value="${user.updateDate}" /></td>
		</tr>
	</table>
	<br>
	<a href="${home}">Home</a>&nbsp;
	<a href="${listUsersUrl}">List users</a>&nbsp;
	<a href="${createUserUrl}">Create user</a>&nbsp;
</body>
</html>