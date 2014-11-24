<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Username</td>
			<td>Name</td>
			<td>Create Date</td>
			<td>Update Date</td>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<c:url var="updateUserUrl" value="/users/updateUserForm">
					<c:param name="id" value="${user.id}" />
				</c:url>
				<td><a href="${updateUserUrl}"><c:out value="${user.username}" /></a></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.createDate}" /></td>
				<td><c:out value="${user.updateDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>