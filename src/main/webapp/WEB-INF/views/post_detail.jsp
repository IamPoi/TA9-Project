<%@page import="com.example.demo.model.UserDTO"%>
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
$(document).ready(function() {
	$("#commentBtn").click(function() {
	const url = new URL(window.location.href);
		const no = url.searchParams;
		$("#commentForm").attr("action", "${root}/comment_write?no="+no.get('no')).submit();
	})
});

$(function(){
	$(".deleteBtn").on("click",function(){
		
		var str = ""
		var tdArr = new Array();
		var btn = $(this);
		var tr = btn.parent().parent();
		var td = tr.children();
		
		var comment_num = td.eq(0).text();
		
		const url = new URL(window.location.href);
		const urlPa = url.searchParams;
		var no =urlPa.get('no')
		
		location.href = 'comment_delete?no='+no+'&comment_num='+comment_num;
		
	});
});

</script>

</head>
<body>

<%UserDTO dto = (UserDTO)session.getAttribute("user"); %>
<c:set var ="id" value = "<%=dto.getId()%>"></c:set>
<h1>${post_detail.title}</h1>

${post_detail.post_num}
${post_detail.content}
${post_detail.writer_id}
<br><br><br><br>
<table class="table table-bordered table-hover text-center">
	<tr>	
		<td>댓글 번호</td>
		<td>댓글 내용</td>
		<td>댓글 작성자</td>
	</tr>
	<c:forEach items="${comment_list}" var = "comment">
		<tr>
			<td>${comment.comment_num}</td>
			<td>${comment.content}</td>
			<c:choose>
				<c:when test="${comment.comment_writer == id}">   
					<td>${comment.comment_writer}<button class = "deleteBtn">삭제</button></td>
				</c:when>
				<c:otherwise>
					<td>${comment.comment_writer}<button style="visibility: hidden;" class = "delteBtn">삭제</button></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
	
</table>

	<form action="comment_write" method="post" id = "commentForm">
		<textarea rows="" cols="" name="content"></textarea>
		<input id = "commentBtn" type="submit" value="등록">
	</form>



</body>
</html>