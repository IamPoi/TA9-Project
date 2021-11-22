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

	/* window.onload = function() {
			var a = document.querySelectorAll("tr")
			$("")
			a.forEach(function(el) {
				el.addEventListener('click', (el) => {
					console.log(el.srcElement.parentNode.childNodes[1].innerText)
				})	
			}) */
/* 			function all(i) {
				
			}
			all = (i) => {
				
			} */
			
			
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
		
		location.replace('post_detail?no='+no);
		
	});		
});

	
</script>
</head>

<body>

<div class="row">
	<div class = "center">${dong_num} 게시판</div>

	<table id="example-table-1" width="80%" class="table table-bordered table-hover text-center">
	<thead>
		<tr>
			<th>No.</th>
			<th>Content</th>
			<th>Writer</th>
		</tr>
	</thead>
	
	<tbody>	
		<c:forEach items="${post_list}" var = "dong">
			<tr>
				<td>${dong.post_num}</td>
				<td>${dong.title}</td>
				<td>${dong.writer_id}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a  href="post_write" id = "post-write" class = "right">글쓰기</a>
</div>	


</body>
</html>