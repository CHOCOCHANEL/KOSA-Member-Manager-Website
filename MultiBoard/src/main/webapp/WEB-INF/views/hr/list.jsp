<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOSA</title>
</head>
<body>
	<h2>협회원 목록</h2>
	<h5>Displayed Members : ${count}</h5>
		<a href = "<c:url value='/'/>">HOME</a>
		<a href = "<c:url value='/hr/insert'/>">협회원 추가하기</a>
	<table border = "1">
		<tr>
			<th>MEMBER_ID</th>
			<th>LAST_NAME</th>
			<th>FIRST_NAME</th>
			<th>EMAIL</th>
			<th>PHONE_NUMBER</th>
			<th>JOB_ID</th>
			<th>MANAGER_ID</th>
			<th>GROUP_ID</th>
			<th>ROLE_ID</th>
		</tr>
		<c:forEach var = "mb" items = "${mbList}">
		<tr>
			<td><a href="<c:url value='/hr/${mb.memberId}'/>">${mb.memberId}</a></td>
			<td>${mb.lastName}</td>
			<td>${mb.firstName}</td>
			<td>${mb.email}</td>
			<td>${mb.phoneNumber}</td>
			<td>${mb.jobId}</td>
			<td>${mb.managerId}</td>
			<td>${mb.groupId}</td>
			<td>${mb.roleId}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>