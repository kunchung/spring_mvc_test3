<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Username</td>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.username}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>