<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url var="updateUserUrl" value="/users/updateUser" />
<c:url var="listUsersUrl" value="/users/listUsers" />
<spring:message var="update" code="general.update" />

<html>
<body>
Edit User<br><br>
	<form:form action="${updateUserUrl}" modelAttribute="user">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><spring:message code="user.username" /></td>
				<td><form:input path="username" /></td>
				<td>
					<form:errors path="number" />
					<form:errors path="username" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="user.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.dateOfBirth" /></td>
				<td><form:input path="dateOfBirth" /></td>
				<td><form:errors path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="${update}" /></td>
			</tr>
		</table>
		<br>
	</form:form>
	<br>
	<a href="${listUsersUrl}">List all users</a><br><br>
</body>
</html>