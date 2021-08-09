<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy List</title>
</head>
<body>
	<h1>사원 목록</h1>
		<a href = "<c:url value='/hr/insert'/>">신규 구성원 정보 입력</a>
	<table border = "1">
		<tr>
			<th>MEMBER_ID</th>
			<th>FIRST_NAME</th>
			<th>LAST_NAME</th>
			<th>EMAIL</th>
			<th>PHONE_NUMBER</th>
			<th>JOB_ID</th>
			<th>MANAGER_ID</th>
			<th>GROUP_ID</th>
			
			<th>START_DATE</th>
			<th>END_DATE</th>
			<th>GROUP_NAME</th>
			<th>ROLE_ID</th>
			<th>ROLE_TITLE</th>
			<th>JOB_TITLE</th>
		</tr>
		<c:forEach var = "mb" items = "${mbList}">
		<tr>
			<td><a href="<c:url value='/hr/${mb.mbId}'/>">${mb.mbId}</a></td>
			<td>${mb.firstName}</td>
			<td>${mb.lastName}</td>
			<td>${mb.email}</td>
			<td>${mb.phoneNumber}</td>
			<td>${mb.jobId}</td>
			<td>${mb.managerId}</td>
			<td>${mb.groupId}</td>
			
			<td>${mb.startDate}</td>
			<td>${mb.endDate}</td>
			<td>${mb.groupName}</td>
			<td>${mb.roleId}</td>
			<td>${mb.roleTitle}</td>
			<td>${mb.jobTitle}</td>
		</tr>
		</c:forEach>
	</table>
		
</body>
</html>