<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
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



</script>
	
</head>
<body>


<%@ include file = "/WEB-INF/views/menu.jsp" %>

<div style="width: 85%;padding-left: 15%;">
	
	<br>
	<table style = "align-content: center;">
		<thead>
			<tr>
				<td><strong>No.</strong></td>
				<td><strong>실시간 뉴스 헤드라인</strong></td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${newsList}" var="news" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><a style = "color: black;" href = "${news.href}" target="blank">${news.title}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	
	<table style = "align-content: center;">
		<thead>
			<tr>
				<td><strong>No.</strong></td>
				<td><strong>부동산 뉴스</strong></td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${newsList2}" var="news" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><a style = "color: black;" href = "${news.href}" target="blank">${news.title}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>