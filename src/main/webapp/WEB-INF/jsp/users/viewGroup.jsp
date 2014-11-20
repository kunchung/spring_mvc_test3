<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="createGroupUrl" value="/users/createGroupForm" />

<html>
<body>
	Group information
	<br> Id:
	<c:out value="${group.id}" />
	<br> Name:
	<c:out value="${group.name}" />
	<br>
	<a href="${createGroupUrl}">Create Group</a>
</body>
</html>