<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewpoint" content="width=device-width, initial-scale=1.0">
<title>CoderBy List</title>
<!-- Favicon -->
<link href="<c:url value='/favicon.png'/>" rel="icon" type="image/png">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".delete").click(function(){
		if(confirm("이 작업은 되돌릴 수 없습니다. 파일을 삭제하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
});
</script>
</head>
<body>
<c:url var="actionnURL" value="/upload/updateDir"/>
<form action="${actionURL}" method="post" enctype="multipart/form-data" class="form-horizontal">
<table border="1">
<tr>
	<th>ID</th>
	<td>경로</td>
	<td>파일명</td>
	<td>크기</td>
	<td>유형</td>
	<td>날짜</td>
	<td>삭제</td>
</tr>
<c:forEach var="file" items="${fileList}">
<tr>
	<td><input type="checkbox" name="fileIds" value="${file.fileId}">${file.fileId}</td>
	<td>${file.directoryName}</td>
	<td><a href="../pds/${file.fileId}">${file.fileName}</a><br></td>
	<td>
		<fmt:formatNumber value="${file.fileSize/1024}" pattern="#,###"/>KB
	</td>
	<td>${file.fileContentType}</td>
	<td>${file.fileUploadDate}</td>
	<td>
		<a href='<c:url value="/upload/delete/${file.fileId}"/>' class="delete">삭제</a>
	</td>
</tr>
</c:forEach>
</table>
<p>선택한 파일을 <select name="directoryName">
	<option value="/">/
	<option value="/images">/이미지
	<option value="/data">/자료실
	<option value="/bigdata">/빅데이터
	<option value="/common">/공통
</select>로 <input type="submit" value="이동"></p>
<a href='<c:url value="/upload/new"/>'>업로드</a>
<a href='<c:url value="/upload"/>'>초기화면</a>
</form>
</body>
</html>