<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:url var="createUserUrl" value="/users/createUserForm" />
<c:url var="listUsersUrl" value="/users/listUsers" />
<c:url var="createGroupUrl" value="/users/createGroupForm" />
<c:url var="listGroupsUrl" value="/users/listGroups" />
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<p>Current Locale : ${pageContext.response.locale}</p>
	
	<a href="${createUserUrl}">Create User</a><br>
	<a href="${listUsersUrl}">List all users</a><br><br>
	<a href="${createGroupUrl}">Create Group</a><br>
	<a href="${listGroupsUrl}">List all groups</a><br><br>
</body>
</html>
