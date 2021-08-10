<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy View</title>
</head>
<body>
	<h1>구성원 과거 조 조회</h1>
	<table border="1">
	<tr>
	<th>MEMBER_ID</th>
	<th>START_DATE</th>
	<th>END_DATE</th>
	<th>GROUP_ID</th>
	<th>GROUP_NAME</th>
	<th>ROLE_ID</th>
	</tr>
	
	<c:forEach var = "history" items = "${historyList}">
	<tr>
	<td>${history.memberId}</td>
	<td>${history.startDate}</td>
	<td>${history.endDate}</td>
	<td>${history.groupId}</td>
	<td>${history.groupName}</td>
	<td>${history.roleId}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>