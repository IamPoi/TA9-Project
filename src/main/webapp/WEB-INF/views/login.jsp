<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#loginBtn").click(function() {
		if($("#userid").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#userpw").val() == "") {
			alert("비밀번호 입력!!!");
			return;
		} else {
			$("#loginform").attr("action", "${root}/login").submit();
		}
	});
	
});
</script>

</head>
<body style = "width : 35%;">
<!-- <body> -->

	<div class="container" align="center" style = "width : 100%;">
		<div class="col-lg-6" align="center">
			<form id="loginform" method="post" action="">
				<div class="form-group" align="left">
					<label for="">아이디</label>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label>
					<input type="password" class="form-control" id="userpw" name="userpw" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}">
				</div>
				<div class="form-group form-check" align="right">
					<label class="form-check-lable">
						<input class="form-check-input" type="checkbox" id="idsave" name="idsave"> 아이디저장
					</label>
				</div>
				<div class="form-group" align="center">
					<button type="button" id="loginBtn" class="btn btn-warning">로그인</button>
					<a href="join_page" id="myRegisterBtn" class="btn btn-primary">회원가입</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>