<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>지금 우리 동네는</title>
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/4/40/Home_Icon_by_Lakas.svg">

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>


	

<style type="text/css">

/* 색 변경 */
:root {
        --text-color: #f0f4f5;
        --background-color: #000a12;
        --accent-color: #ffa726;
}
body {
        margin: 0;
}
a {
        text-decoration: none;
        color: var(--text-color);
}
.navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: var(--background-color);
        padding: 8px 12px;
        font-family: 'Source Sans Pro', sans-serif;
}
.navbar__logo {
       font-size: 24px;
       color: var(--text-color);
}
.navbar__logo i {
       color: var(--accent-color);
}
.navbar__menu {
        display: flex;
        list-style: none;
        padding-left: 0;
}
.navbar__menu li {
        padding: 8px 12px;
}
.navbar__menu li:hover {
        background-color: var(--accent-color);
        border-radius: 4px;
}
.navbar__sns {
        list-style: none;
        display: flex;
        padding-left: 0;
}
.navbar__sns li {
        padding: 8px 12px;
}
.navbar__toggleBtn {
        display: none;
        position: absolute;
        right: 32px;
        font-size: 24px;
        color: var(--accent-color);
}
@media screen and (max-width: 768px) {
        .navbar {
                flex-direction: column;
                align-items: flex-start;
                padding: 8px 24px;
        }
        .navbar__menu {
                display: none;
                flex-direction: column;
                align-items: center;
                width: 100%;
        }
        .navbar__menu li {
                width: 100%;
                text-align: center;
        }
        .navbar__sns {
                display: none;
                justify-content: center;
                width: 100%;
         }
        .navbar__toggleBtn {
                 display: block;
         }
        .navbar__menu.active,
        .navbar__sns.active {
                display: flex;
        }
}

</style>

<script type="text/javascript">
const toggleBtn = document.querySelector('.navbar__toggleBtn');
const menu = document.querySelector('.navbar__menu');
const sns = document.querySelector('.navbar__sns');


function login(){
	
	alert("로그인 해주세요");
	
}


</script>
</head>

<body>

	<nav class="navbar">
		<div class="navbar__logo" style = "padding-left : 3%;">
			<i class="fab fa-amazon"><link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/4/40/Home_Icon_by_Lakas.svg"></i> <a href="/">지금 우리 동네는</a>
		</div>
		<ul class="navbar__menu" style ="padding-right: 3%; padding-top: 1%;">
			

			<%if (session.getAttribute("user") == null) { %>
			<li><a href="/">홈</a></li>
			<%-- <li><a href="${root}/admin">관리자</a></li> --%>
			<li><a href="${root}/login_page" onclick="login()">게시판</a></li>
			<li><a href="${root}/login_page" onclick="login()">마이페이지</a></li>
			<li><a href="${root}/login_page" onclick="login()">랭킹</a></li>
			<li><a href="${root}/join_page">회원가입</a></li>
			<li><a href="${root}/login_page">로그인</a></li>
			
			<%} else {%>
			<li><a href="/">홈</a></li>			
			<%-- <li><a href="${root}/admin">관리자</a></li> --%>
			<li><a href="${root}/post">게시판</a></li>
			<li><a href="${root}/mypage">마이페이지</a></li>
			<li><a href="${root}/rankView">랭킹</a></li>
			<li><a href="${root}/logout">로그아웃</a></li>
			<!-- <li><a href="http://localhost:8088/pandora3/bo">판도라ㄱㄱ</a></li> -->
			
			<%} %>
			<c:if test="${user != null}">
				<li style="color: white; padding-top: 1%">
					<strong>${user.name}</strong>님 환영합니다.<br>
				</li>
				<%-- <a href="${root}/mypage">마이페이지</a>
				<br>
				<a href="${root}/post">게시판</a>
				<br>
				<a href="${root}/logout">로그아웃</a> --%>
			</c:if>
			<c:if test="${user == null}">
			</c:if>
		</ul>
		<!-- <ul class="navbar__sns">
			<li><a href="#"><i class="fab fa-twitter"></i></a></li>
			<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
		</ul>
		<a href="#" class="navbar__toggleBtn"> <i class="fas fa-bars"></i>
		</a> -->
	</nav>

</body>
</html>