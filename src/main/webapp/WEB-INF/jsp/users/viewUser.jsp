<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="createUserUrl" value="/users/createUserForm" />
<html>
<body>
	Id:
	<c:out value="${user.id}" />
	<br> Username:
	<c:out value="${user.username}" />
	<br>
	<a href="${createUserUrl}">Create User</a>
</body>
</html>