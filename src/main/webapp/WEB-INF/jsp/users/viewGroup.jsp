<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="createGroupUrl" value="/users/createGroupForm" />

<html>
<body>
	Group Information
	<br>
	<br> Id:
	<c:out value="${group.id}" />
	<br> Name:
	<c:out value="${group.name}" />
	<br>
	User list:<br>
	<c:forEach var="item" items="${group.itemList}">
		<c:out value="${item.user.username}" />
		<br>
	</c:forEach>
	<br>
	<br>
	<a href="${createGroupUrl}">Create Group</a>
</body>
</html>