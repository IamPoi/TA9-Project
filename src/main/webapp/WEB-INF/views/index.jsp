<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
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

</script>
	
</head>
<body>
	<div align="right">
		<c:if test="${user == null}">
			<h3>${msg}</h3>
			<div align="right">
				<%@ include file = "/WEB-INF/views/login.jsp" %>
			</div>
		</c:if>
		
		<c:if test="${user != null}">
			<div>
				<strong>${user.name}</strong>님 환영합니다.
				<a href="${root}/logout">로그아웃</a>
			</div>
			<a href="${root}/mypage">마이페이지</a><br>
			<a href="${root}/post">게시판</a><br>
			<%-- <a href="${root}/userList">회원목록</a> --%>
		</c:if>
	</div>
</body>
</html>