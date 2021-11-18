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
	
$("#example-table-1 tr").click(function(){ 	

	var str = ""
	var tdArr = new Array();	// 배열 선언
	
	// 현재 클릭된 Row(<tr>)
	var tr = $(this);
	var td = tr.children();
	
	// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
	td.each(function(i){
		tdArr.push(td.eq(i).text());
	});
	
	console.log("배열에 담긴 값 : "+tdArr);
	
	// td.eq(index)를 통해 값을 가져올 수도 있다.
	var no = td.eq(0).text();
	
	str +=	"No." + no;	
			
});
	
</script>
</head>

<body>

<div class="row">
	<h1 class = "center">${dong_num} 게시판</h1>

	<table id="example-table-1" width="100%" class="table table-bordered table-hover text-center">
		<tr>
			<th>No.</th>
			<th>Content</th>
			<th>Writer</th>
		</tr>
		
		<c:forEach items="${post_list}" var = "dong">
			<tr>
				<td>${dong.post_num}</td>
				<td>${dong.content}</td>
				<td>${dong.writer_id}</td>
			</tr>
		</c:forEach>
	</table>
</div>	
		<div class="col-lg-12" id="ex1_Result1" ></div> 
		<div class="col-lg-12" id="ex1_Result2" ></div> 
	
	
	

</body>
</html>