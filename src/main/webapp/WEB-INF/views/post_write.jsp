<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<script src="https://cdn.ckeditor.com/ckeditor5/31.0.0/classic/ckeditor.js">
</script>

<script type="text/javascript">


</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

	<form action="${root}/post_enrollment" method="post">
		제목 <input type="text" name="title">
		<textarea style = "height:500px" name="content" id="content_textarea"></textarea>
		<button id = "button">dd</button>
		<input type="submit" value="글 등록" id="submit-btn">
	</form>
	
	<script type="text/javascript">
	ClassicEditor
    .create(document.querySelector('#content_textarea'))
    .catch(error=>{
      console.error(error);
    });
	</script>
</body>
</html>