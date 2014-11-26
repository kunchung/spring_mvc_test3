<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<p>Current Locale : ${pageContext.response.locale}</p>
	<table border="1">
		<tr>
			<td><spring:message code="user.id" /></td>
			<td><spring:message code="user.username" /></td>
			<td><spring:message code="user.name" /></td>
			<td><spring:message code="user.dateOfBirth" /></td>
			<td><spring:message code="general.createDate" /></td>
			<td><spring:message code="general.updateDate" /></td>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<c:url var="updateUserUrl" value="/users/updateUserForm">
					<c:param name="id" value="${user.id}" />
				</c:url>
				<td><a href="${updateUserUrl}"><c:out value="${user.username}" /></a></td>
				<td><c:out value="${user.name}" /></td>
				<td><fmt:formatDate value="${user.dateOfBirth}" pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${user.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>