<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${root}/post_enrollment" method="post">
		제목 <input type="text" name="title">
		<textarea rows="" cols="" name="content"></textarea>

		<input type="submit" value="글 등록" id="submit-btn">
	</form>
</body>
</html>