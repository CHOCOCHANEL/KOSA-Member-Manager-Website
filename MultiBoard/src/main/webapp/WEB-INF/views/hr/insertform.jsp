<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOSA</title>
</head>
<body>
	<h2>구성원 정보 입력</h2>
	<a href = "<c:url value='/'/>">HOME</a>
	<form action="./insert" method="post">
	<table border="1">
	<tr>
		<th>MEMBER_ID</th>
		<td><input type="number" name="memberId" required></td>
	</tr>
	<tr>
		<th>FIRST_NAME</th>
		<td><input type="text" name="firstName"></td>
	</tr>
	<tr>
		<th>LAST_NAME</th>
		<td><input type="text" name="lastName" required></td>
	</tr>
	<tr>
		<th>EMAIL</th>
		<td><input type="text" name="email" required></td>
	</tr>
	<tr>
		<th>PHONE_NUMBER</th>
		<td><input type="text" name="phoneNumber"></td>
	</tr>
	<tr>
		<th>JOB_ID</th>
		<td>
			<select name="jobId">
			<c:forEach var="job" items="${jobList}">
				<option value="${job.jobId}">${job.title}</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th>MANAGER_ID</th>
		<td>
		<select name="managerId">
		<c:forEach var="manager" items="${managerList}">
			<option value="${manager.managerId}">${manager.lastName + manager.firstName}</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	
	<tr>
		<th>GROUP_ID</th>
		<td><input type="text" name="groupId">(0~6)</td>
	</tr>
	
	<tr>
		<th>ROLE_ID</th>
		<td><input type="text" name="roleId">GL(Leader)/GM(Manager)</td>
	</tr>
	
	<tr>
		<th>&nbsp;</th>
		<td>
			<input type="submit" value="저장">
			<input type="reset" value="취소">
		</td>
	</tr>
	</table>
	</form>
</body>
</html>