<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url var="createUserUrl" value="/users/createUser" />
<spring:message var="register" code="user.register" />

<html>
<body>
	<form:form action="${createUserUrl}" modelAttribute="user">
		<table>
			<tr>
				<td><spring:message code="user.username" /></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.name" /></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="${register}" /></td>
			</tr>
		</table>
		<br>
	</form:form>
</body>
</html>