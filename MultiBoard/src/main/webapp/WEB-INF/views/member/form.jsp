<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18n/member"/>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/include/staticFiles.jsp"/>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
		// JavaScript form validation
		var checkPassword = function(str){
			var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
			return re.test(str);
		};
		
		var checkForm = function(e){
			if(this.username.value == ""){
				alert("Error: Username cannot be blank!");
				this.username.focus();
				e.preventDefault(); // equivalent to return false
				return;
			}
			re = /^\w+$/;
			if(!re.test(this.username.value)){
				alert("Error: Username must contain only letter, numbers and underscores!");
				this.username.focus();
				e.preventDefault();
				return;
			}
			if(this.pwd1.value != "" && this.pwd1.value == this.pwd2.value){
				if(!checkPassword(this.pwd1.value)){
					alert("The password you have entered is not valid!");
					this.pwd1.focus();
					e.preventDefault();
					return;
				}
			} else {
				alert("Error: Please check that you've entered confirmed your password!");
				this.pwd1.focus();
				e.preventDefault();
				return;
			}
			alert("Both username and password are VALID!");
		};
		
		var myForm = document.getElementById("joinForm");
		myForm.addEventListener("submit", checkForm, true);
		
		// HTML form validation
		var supports_input_validity = function() {
			var i = document.createElement("input");
			return "setCustomValidity" in i;
		}
		
		if(supports_input_validity()){
			var usernameInput = document.getElementById("userid");
			usernameInput.setCustomValidity(usernameInput.title);
			
			var pwd1Input = document.getElementById("password");
			pwd1Input.setCustomValidity(pwd1Input.title);
			
			var pwd2Input = document.getElementById("password_re");
			
			// input key handlers
			
			usernameInput.addEventListener("keyup", function(){
				usernameInput.setCustomValidity(this.validity.patternMismatch ? usernameInput.title : "");				
			}, false);
			
			pwd1Input.addEventListener("keyup", function(){
				this.setCustomValidity(this.validity.patternMismatch ? pwd1Input.title : "");
				if(this.checkValidity()){
					pwd2Input.pattern = this.value;
					pwd2Input.setCustomValidity(pwd2Input.title);
				} else {
					pwd2Input.pattern = this.pattern;
					pwd2Input.setCustomValidity("");
				}
			}, false);
			
			pwd2Input.addEventListener("keyup", function() {
				this.setCustomValidity(this.validity.patternMismatch ? pwd2Input.title : "");
			}, false);
			
		}
		
	}, false);
</script>
<body>
<jsp:include page="/WEB-INF/views/include/bodyHeader.jsp"/>
<div class="container">
	<div class="pg-opt">
		<div class="row">
			<div class="col-md-6 pc">
				<h2><fmt:message key="INSERT_USER_INFO"/></h2>
			</div>
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><fmt:message key="MEMBER"/></li>
					<li class="active"><fmt:message key="INSERT_USER_INFO"/></li>
				</ol>
			</div>
		</div>
	</div>
	<div class="content">
	<form action="<c:url value='/member/insert.do'/>" method="post" id="joinForm" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-sm-2" for="userid"><fmt:message key="MEMBER_ID"/></label>
		<div class="col-sm-4">
			<input type="text" name="userid" id="userid" value="${member['userid']}" ${empty member.userid ? "" : "readonly"} title="<fmt:message key='USERID_TITLE'/>" pattern="\w+" class="form-control" placeholder="<fmt:message key="MEMBER_ID"/>" required>
		</div>
	</div>
	<div class="form-group">
		<label class="control-lavel col-sm-2" for="password"><fmt:message key="MEMBER_PW"/></label>
		<div class="col-sm-4">
			<input type="password" name="password" id="password" value="${member.password}" class="form-control" title="<fmt:message key='PASSWORD_TITLE'/>" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" required>
		</div>
	</div>
	
	</form>
	</div>
</div>
</body>
</html>