<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:url var="createUserUrl" value="/users/createUserForm" />
<c:url var="createGroupUrl" value="/users/createGroupForm" />
<c:url var="listUsersUrl" value="/users/listUsers" />
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	
	<a href="${createUserUrl}">Create User</a><br>
	<a href="${listUsersUrl}">List all users</a><br>
	<a href="${createGroupUrl}">Create Group</a><br>
</body>
</html>
