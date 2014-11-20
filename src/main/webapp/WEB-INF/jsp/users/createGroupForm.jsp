<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url var="createGroupUrl" value="/users/createGroup" />
<spring:message var="createGroup" code="userGroup.createGroup"/>

<html>
<form:form action="${createGroupUrl}" modelAttribute="userGroup">
	<spring:message code="userGroup.name"/> <form:input path="name"/><br>
	<input type="submit" value="${createGroup}"></input>
</form:form>
</html>