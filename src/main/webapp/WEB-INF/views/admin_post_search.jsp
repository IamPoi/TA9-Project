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
<link rel="shortcut icon" type="image/x-icon"
	href="https://upload.wikimedia.org/wikipedia/commons/4/40/Home_Icon_by_Lakas.svg">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		$(".deleteBtn").on("click", function() {

			var str = ""
			var tdArr = new Array();
			var btn = $(this);
			var tr = btn.parent().parent();
			var td = tr.children();

			var no = td.eq(0).text();

			alert(no)
			
		
			location.href = 'admin_post_delete?no=' + no;

		});
	});
	
	
	

	$(function() {
		$("#search").on(
				"click",
				function() {

					console.log("gdgdg")

					var search = $('#text').val()

					var singo = 0;

					if ($('#singo').is(":checked")) {
						singo = 1;
					}

					location.href = 'admin_post_search?search=' + search
							+ '&singo=' + singo;

				});
	});
</script>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	<br>
	<div class="row" style="padding-left: 15%; width: 85%;">

		<form action="admin_post_search" method="get">
			<input type="text" id = 'text' placeholder="검색 할 내용" name="search">
			<input type="checkbox" id = 'singo' name = "singo" checked="on">신고
			
		 	<!-- <input id = 'search' type="submit" value="검색"> -->
		 	<button type="button" id = "search">검색</button>
		</form>


		<table id="example-table-1" style="width: 100%;"
			class="table table-bordered table-hover text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>Title</th>
					<th>Writer</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${post_list}" var="post">
					<tr>
						<td>${post.post_num}</td>
						<td>${post.title}</td>
						<td>${post.writer_id}<button class="deleteBtn">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>