<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지금 우리 동네는</title>
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/4/40/Home_Icon_by_Lakas.svg">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>


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
<body>
<%@ include file = "/WEB-INF/views/menu.jsp" %>

<br>
	<div class="container" align="center" style = "width : 100%;">
		<div class="col-lg-6" align="center">
			<form id="loginform" method="post" action="">
				<div class="form-group" align="left">
					<label for="">아이디</label>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="" onkeyup="this.value=this.value.replace(/[^a-zA-Z-_0-9]/g,'');">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label>
					<input type="password" class="form-control" id="userpw" name="userpw" placeholder="">
				</div>
				<div class="form-group form-check" align="right">
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