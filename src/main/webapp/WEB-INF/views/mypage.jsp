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
	
<script type="text/javascript">

$(function() {
	$("#example-table-1 tbody").on("click","tr",function(){
		var str = ""
		var tdArr = new Array();	// 배열 선언
		
		// 현재 클릭된 Row(<tr>)
		var tr = $(this);
		var td = tr.children();
		
		// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
		td.each(function(i){
			tdArr.push(td.eq(i).text());
		});
		
		// td.eq(index)를 통해 값을 가져올 수도 있다.
		var no = td.eq(0).text();
		
		str +=	"No." + no;
		console.log(no)
		
		location.href = 'post_detail?no='+no;
		
	});
});
</script>

</head>
<body>



<%@ include file = "/WEB-INF/views/menu.jsp" %>

<%UserDTO dto = (UserDTO)session.getAttribute("user"); %>

<div style = "padding-left: 10%; width: 90%;">
<h1><%=dto.getName() %>의 마이 페이지</h1>


<%=dto.getApt() %> <br>
${aptInfo.min_price/100000000}억 ~ ${aptInfo.max_price/100000000}억

<h1>내가 쓴 게시글</h1>
<table class="table table-bordered table-hover text-center" id = "example-table-1">
<thead>
	<tr>	
		<td>게시글 번호</td>
		<td>게시글 제목</td>
		<td>게시글 작성자</td>
	</tr>
</thead>
	<tbody>
	<c:forEach items="${myPostList}" var = "my_post">
		<tr>
			<td>${my_post.post_num}</td>
			<td>${my_post.title}</td>
			<td>${my_post.writer_id}</td>
		</tr>
	</c:forEach>
	</tbody>
	
</table>

<h1>내가 쓴 댓글</h1>

<table class="table table-bordered table-hover text-center">
	<tr>	
		<td>댓글 번호</td>
		<td>댓글 내용</td>
		<td>댓글 작성자</td>
	</tr>
	<c:forEach items="${myCommentList}" var = "my_comment">
		<tr>
			<td>${my_comment.comment_num}</td>
			<td>${my_comment.content}</td>
			<td>${my_comment.comment_writer}</td>
		</tr>
	</c:forEach>
	
</table>


</div>
</body>
</html>