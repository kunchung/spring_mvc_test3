<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url var="updateUserUrl" value="/users/updateUser" />
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
				<td><form:errors path="number" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="${update}" /></td>
			</tr>
		</table>
		<br>
	</form:form>
</body>
</html>