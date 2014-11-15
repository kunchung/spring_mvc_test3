<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url var="regUserUrl" value="/users/register" />
<spring:message var="register" code="user.register"/>

<html>
<form:form action="${regUserUrl}" modelAttribute="user">
	<spring:message code="user.username"/> <form:input path="username"/><br>
	<input type="submit" value="${register}"></input>
</form:form>
</html>