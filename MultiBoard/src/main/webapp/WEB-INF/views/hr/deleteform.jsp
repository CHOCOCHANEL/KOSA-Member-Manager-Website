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
	<h2>협회원 정보 삭제</h2>
	<p>${mb.lastName}${mb.firstName}의 정보를 삭제합니다.</p>
	<p>삭제후 데이터는 복구될 수 없습니다. </p>
	<p>해당 협회원 (${mb.lastName}${mb.firstName}) 의 이메일을 입력하세요.</p>
	<form action="./delete" method="post">
	이메일 : <input type="text" name="email">
	<input type="hidden" name="mbid" value="${mb.memberId}">
	<input type="submit" value="삭제">
	<a href="list">취소</a>
	<a href="<c:url value='/'/>">HOME</a>
	</form>
</body>
</html>