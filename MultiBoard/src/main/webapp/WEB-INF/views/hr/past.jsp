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


private int memberId;
	private Date startDate;
	private Date endDate;
	private int groupId;
	private String groupName;
	private String roleId;
	
	
	<h1>구성원 정보 상세 조회</h1>
	<table border="1">
	<tr>
		<th>MEMBER_ID</th>
		<td>${gh.mbId}</td>
	</tr>
	<tr>
		<th>START_DATE</th>
		<td>${gh.startDate}</td>
	</tr>
	<tr>
		<th>END_DATE</th>
		<td>${gh.endDate}</td>
	</tr>
	<tr>
		<th>GROUP_ID</th>
		<td>${gh.groupId}</td>
	</tr>
	<tr>
		<th>GROUP_NAME</th>
		<td>${gh.groupName}</td>
	</tr>
	<tr>
		<th>ROLE_ID</th>
		<td>${gh.roleId}</td>
	</tr>
	</table>
</body>
</html>
