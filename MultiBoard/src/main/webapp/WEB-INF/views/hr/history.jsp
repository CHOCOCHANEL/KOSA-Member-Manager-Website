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
	<h2>조 변경 내역보기</h2>
	<a href = "<c:url value='/'/>">HOME</a>
	<form action="./history" method="post">
	<table border="1">
	<tr>
	<th>이름으로 조회</th>
		<td>
		<select name="memberId">
			<c:forEach var="member" items="${memberList}">
				<option value="${member.memberId}">${member.memberId}.${member.lastName}${member.firstName}</option>
			</c:forEach>
		</select>
		</td>
		<td>
			<input type="submit" value="조회"/>
		</td>
	</tr>
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
	</form>
</body>
</html>