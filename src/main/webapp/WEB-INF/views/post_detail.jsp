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
	
</head>
<body>

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
	<tr>	
		<td>1</td>
		<td>???</td>
		<td>pcy</td>
	</tr>
	<tr>	
		<td>2</td>
		<td>안녕하세요</td>
		<td>qwe</td>
	</tr>
	
</table>

	<form action="" method="post">
		<textarea rows="" cols="" name="comment"></textarea>
		<input type="submit" value="등록">
	</form>



</body>
</html>