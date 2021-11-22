<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
	$("#joinBtn").click(function() {
		if($("#userid").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#userpw").val() == "") {
			alert("비밀번호 입력!!!");
			return;
		} else if($("#username").val() == "") {
			alert("이름 입력!!!");
			return;
		} else if($("#userdong_num").val() == "") {
			alert("동번호 입력!!!");
			return;
		} else if($("#userapt").val() == "") {
			alert("아파트 입력!!!");
			return;
		} else {
			$("#joinform").attr("action", "${root}/join").submit();
		}
	});
	
});


</script>

</head>
<body>

<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<form id="joinform" method="post" action="">
				<div class="form-group" align="left">
					<label for="">아이디</label>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label>
					<input type="password" class="form-control" id="userpw" name="userpw" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}">
				</div>
				<div class="form-group" align="left">
					<label for="">이름</label>
					<input type="text" class="form-control" id="username" name="username" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">동번호</label>
					<input type="text" class="form-control" id="userdong_num" name="userdong_num" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">아파트 이름</label>
					<input type="text" class="form-control" id="userapt" name="userapt" placeholder="">
				</div>
				<div class="form-group" align="center">
					<button type="button" id="joinBtn" class="btn btn-warning">회원가입</button>
				</div>
			</form>


		</div>
	</div>

</body>
</html>