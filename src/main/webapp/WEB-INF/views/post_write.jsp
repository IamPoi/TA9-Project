<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<script src="https://cdn.ckeditor.com/ckeditor5/31.0.0/classic/ckeditor.js"></script>
<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>


<script type="text/javascript">


</script>

<style type="text/css">

.ck-content{
	height: 300px;
} 





</style>
<meta charset="UTF-8">
<title>지금 우리 동네는</title>
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/4/40/Home_Icon_by_Lakas.svg">
</head>
<body> 

<%@ include file = "/WEB-INF/views/menu.jsp" %>
<br>
<div align="center"  style="width: 85%; padding-left: 15%;">
	<form action="${root}/post_enrollment" method="post" enctype="multipart/form-data">
		제목 <input type="text" id = "title" name="title" style=""><br><br>
		<textarea style = "height:500px" name="content" id="content_textarea"></textarea>
		<input type="file" name="img_name" multiple="multiple"/><br>
		<input type="submit" id = "button" value="글 등록" id="submit-btn" onclick="getData()">
	</form>
	
</div>
	<script type="text/javascript">
	ClassicEditor
    .create(document.querySelector('#content_textarea'),{
    	ckfinder:{
    		uploadUrl:'/image'
    		//uploadUrl: '/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files&responseType=json'
    		}
    })
    .catch(error=>{
      console.error(error);
    });
	</script>
</body>
</html>