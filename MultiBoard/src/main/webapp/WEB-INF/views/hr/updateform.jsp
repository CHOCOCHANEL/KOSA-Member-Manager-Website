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
	<h2>구성원 정보 수정</h2>
	<a href = "<c:url value='/'/>">HOME</a>
	<form action="./update" method="post">
	<table border="1">
	<tr>
		<th>MEMBER_ID</th>
		<td><input type="number" name="memberId" value="${mb.memberId}" readonly></td>
	</tr>
	<tr>
		<th>FIRST_NAME</th>
		<td><input type="text" name="firstName" value="${mb.firstName}"></td>
	</tr>
	<tr>
		<th>LAST_NAME</th>
		<td><input type="text" name="lastName" value="${mb.lastName}" required></td>
	</tr>
	<tr>
		<th>EMAIL</th>
		<td><input type="text" name="email" value="${mb.email}" required></td>
	</tr>
	<tr>
		<th>PHONE_NUMBER</th>
		<td><input type="text" name="phoneNumber" value="${mb.phoneNumber}"></td>
	</tr>	

	<tr>
		<th>JOB_ID</th>
		<td>
		<select name="jobId">
		<c:forEach var="job" items="${jobList}">
			<c:if test="${mb.jobId == job.jobId}">
				<option value="${job.jobId}" selected>${job.title}</option>
			</c:if>
			<c:if test="${mb.jobId != job.jobId}">
				<option value="${job.jobId}">${job.title}</option>
			</c:if>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<th>MANAGER_ID</th>
		<td>
			<select name="managerId">
			<c:forEach var="manager" items="${managerList}">
				<c:if test="${mb.managerId == manager.memberId}">
					<option value="${mb.managerId}" selected>${manager.lastName}${manager.firstName}</option>
				</c:if>
				<c:if test="${mb.managerId != manager.memberId}">
					<option value="${mb.managerId}">${manager.lastName}${manager.firstName}</option>
				</c:if>
			</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr>
		<th>GROUP_ID</th>
		<td>
		<select name="groupId">
		<c:forEach var="group" items="${groupList}">
			<c:if test="${mb.groupId == group.groupId}">
				<option value="${group.groupId}" selected>${group.groupName}</option>
			</c:if>
			<c:if test="${mb.groupId != group.groupId}">
				<option value="${group.groupId}">${group.groupName}</option>
			</c:if>
		</c:forEach>
		</select>
		</td>
	</tr>
	
	<tr>
		<th>ROLE_ID</th>
		<td><input type="text" name="roleId" value="${mb.roleId}">GL(Leader)/GM(Member)</td>
	</tr>	
	<tr>
		<th>&nbsp;</th>
		<td>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		</td>
	</tr>
	</table>
	</form>
</body>
</html>