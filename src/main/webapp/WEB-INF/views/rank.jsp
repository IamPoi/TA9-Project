<%@page import="com.example.demo.model.UserDTO"%>
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
	
</head>
<body>

<%@ include file = "/WEB-INF/views/menu.jsp" %>

<br>
<div style = "width : 85%;padding-left: 15%;">
<strong>${location.dong}의 아파트 순위</strong>
<table id="example-table-1" class="table table-bordered table-hover text-center">
	<thead>
		<tr>
			<th>No.</th>
			<th>APT</th>
			<th>MAX_PRICE</th>
		</tr>
	</thead>
	
	<tbody>	
		<c:forEach items="${rank_list}" var = "rank" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><a style = "color:black;" href = "/apt_detail?road_name=${rank.road_name}&road_num=${rank.road_num}&apt=${rank.apt}">${rank.apt}</a></td>
				<td>${rank.max_price}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
<br>



</body>
</html>