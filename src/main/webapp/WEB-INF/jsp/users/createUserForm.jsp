<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url var="createUserUrl" value="/users/createUser" />
<spring:message var="create" code="general.create" />

<html>
<body>
Create User<br>
	<form:form action="${createUserUrl}" modelAttribute="user">
		<table>
			<tr>
				<td><spring:message code="user.username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="number" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="${create}" /></td>
			</tr>
		</table>
		<br>
	</form:form>
</body>
</html>