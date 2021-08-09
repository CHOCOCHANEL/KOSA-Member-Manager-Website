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
	<h1>사원 정보 상세 조회</h1>
	<table border="1">
	<tr>
		<th>MEMBER_ID</th>
		<td>${mb.mbId}</td>
	</tr>
	<tr>
		<th>FIRST_NAME</th>
		<td>${mb.firstName}</td>
	</tr>
	<tr>
		<th>LAST_NAME</th>
		<td>${mb.lastName}</td>
	</tr>
	<tr>
		<th>EMAIL</th>
		<td>${mb.email}</td>
	</tr>
	<tr>
		<th>PHONE_NUMBER</th>
		<td>${mb.phoneNumber}</td>
	</tr>
	<tr>
		<th>JOB_ID</th>
		<td>${mb.jobId}</td>
	</tr>
	<tr>
		<th>MANAGER_ID</th>
		<td>${mb.managerId}</td>
	</tr>
	<tr>
		<th>GROUP_ID</th>
		<td>${mb.groupId}</td>
	</tr> 
	
	<tr>
		<th>START_DATE</th>
		<td>${mb.startDate}</td>
	</tr>
	<tr>
		<th>END_DATE</th>
		<td>${mb.endDate}</td>
	</tr>
		<tr>
		<th>GROUP_NAME</th>
		<td>${mb.groupName}</td>
	</tr>
		<tr>
		<th>ROLE_ID</th>
		<td>${mb.roleId}</td>
	</tr>
		<tr>
		<th>ROLE_TITLE</th>
		<td>${mb.roleTitle}</td>
	</tr>
		<tr>
		<th>JOB_TITLE</th>
		<td>${mb.jobTitle}</td>
	</tr>
	</table>
	<a href="update?empid=${emp.employeeId}">수정하기</a>
	<a href="delete?empid=${emp.employeeId}">삭제하기</a>
</body>
</html>