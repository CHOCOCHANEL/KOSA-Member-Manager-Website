  
<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18n/header" />
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/include/staticFiles.jsp"/>
<body>
<jsp:include page="/WEB-INF/views/include/bodyHeader.jsp"/>
<div class="container">
	<div class="pg-opt">
        <div class="row">
            <div class="col-md-6 pc">
                <h2><fmt:message key="HOME"/></h2>
            </div>
            <div class="col-md-6">
                <ol class="breadcrumb">
                    <li><fmt:message key="DASHBOARD"/></li>
                    <li class="active"><fmt:message key="HOME"/></li>
                </ol>
            </div>
        </div>
    </div>

	<div class="content">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
					<a href="board/cat/1"><h3>공지사항</h3></a><br>
					<a href="board/cat/2"><h3>질의응답</h3></a><br>
					<a href="board/cat/3"><h3>응답하라KOSA</h3></a><br>
					</div>
				<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				몇번째 수정인지 알 수 없다~</div>
				<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				깃은 왜 잘 안되고 난리~</div>
			</div>
			<div class="progress">
		<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
		<span class="sr-only"></span>
		</div>
	</div>
	<div class="progress">
		<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
		<span class="sr-only"></span>
		</div>
	</div>
	<div class="alert alert-info">
		<ol>
			<li>두둥두둥 뭐라고 쓰지~
		</ol>
	</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>