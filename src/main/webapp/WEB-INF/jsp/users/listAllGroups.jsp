<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="createGroupUrl" value="/users/createGroupForm" />

<html>
<body>
	<table border="1">
		<tr>
			<td>Group Id</td>
			<td>Group Name</td>
			<td>User List</td>
		</tr>
		<c:forEach var="group" items="${groupList}">
			<tr>
				<td><c:out value="${group.id}" /></td>
				<td><c:out value="${group.name}" /></td>
				<td><c:forEach var="item" items="${group.itemList}">
						<c:out value="${item.user.username}" />,
					</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="${createGroupUrl}">Create Group</a>
</body>
</html>