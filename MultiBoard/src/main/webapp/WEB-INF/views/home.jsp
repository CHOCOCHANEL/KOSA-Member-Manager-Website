  
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
					<a href="board/cat/2"><h3>취업정보</h3></a><br>
					<a href="board/cat/3"><h3>응답하라KOSA</h3></a><br>
					</div>
				<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				<img src=" https://newsimg.hankookilbo.com/cms/articlerelease/2019/04/29/201904291390027161_3.jpg" width="300" height="150">
				</div>
				<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				<img src="data:image/jpeg;base64,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" width="300" height="150">
				</div>
			</div>
		<div class="alert alert-info">
			<ol>
				<li>5조 : 문종현 윤다영 정재홍 정현지
			</ol>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>