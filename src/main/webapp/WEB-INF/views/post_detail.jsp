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
		no.get('no')
		console.log(no.get('no'));
		$("#commentForm").attr("action", "${root}/comment_write?no="+no.get('no')).submit();
	})
});

</script>

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
	<c:forEach items="${comment_list}" var = "comment">
		<tr>
			<td>${comment.comment_num}</td>
			<td>${comment.content}</td>
			<td>${comment.comment_writer}</td>
		</tr>
	</c:forEach>
	
</table>

	<form action="comment_write" method="post" id = "commentForm">
		<textarea rows="" cols="" name="content"></textarea>
		<input id = "commentBtn" type="submit" value="등록">
	</form>



</body>
</html>