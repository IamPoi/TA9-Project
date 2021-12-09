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

<%UserDTO dto = (UserDTO)session.getAttribute("user"); %>
<c:set var ="id" value = "<%=dto.getId()%>"></c:set>



<script type="text/javascript">


$(document).ready(function() {
	$("#commentBtn").click(function() {
	const url = new URL(window.location.href);
		const no = url.searchParams;
		$("#commentForm").attr("action", "${root}/comment_write?no="+no.get('no')).submit();
	})
});


$(function(){
	$(".input-c").focusout(function(){
		
		$('.div-c').css("display","block");
		$('.input-c').css("display","none");
		
	});	
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



$(function(){
	$(".updateBtn").on("click",function(){
		
		var str = ""
		var tdArr = new Array();
		var btn = $(this);
		var tr = btn.parent().parent();
		var td = tr.children();
		
		var comment_num = td.eq(0).text();
		
		const url = new URL(window.location.href);
		const urlPa = url.searchParams;
		var no =urlPa.get('no');
		
		
		var content = $("."+comment_num+"_input").val();
		
		//console.log(comment_num)
		//console.log(content);
		
		location.href = 'comment_update?no='+no+'&comment_num='+comment_num+'&content='+content;
		
	});
});

$(function() {
	$("#example-table-1 tbody").on("click","tr",function(){
		
		<%dto = (UserDTO)session.getAttribute("user"); %>
	
		$('.div-c').css("display","block");
		$('.input-c').css("display","none");
		
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
		var comment_num = td.eq(0).text();
		var writer = td.eq(2).text().split(",",1)[0];
		
		console.log(comment_num);
		console.log(writer);
		
		var id = '<%=String.valueOf(dto.getId())%>'; 
		
		
		if(writer == id){ 
			
		console.log("????")
		var div = $("."+comment_num+"_div");
			
		var input = $("."+comment_num+"_input");
		
		div.css("display","none");
		input.css("display","block");		
		
		input.focus();
		}
		
		
	});
});

$(function(){
	$("#decl-button").on('click',function(){
		
		const url = new URL(window.location.href);
		const urlPa = url.searchParams;
		var no =urlPa.get('no');
		
		
		location.href = "declaration?no="+no;
	})
})






</script>



</head>
<body>

<%@ include file = "/WEB-INF/views/menu.jsp" %>

<div style="width: 85%;padding-left: 15%; ">
<br>
<h1>${sessionScope.user_location.dong} ${apt_detail.apt}</h1>
<div align="right">
<strong>최저 : ${apt_detail.min_price}</strong>
<strong>최고 : ${apt_detail.max_price}</strong>
<strong>평균 : ${apt_detail.avg_price}</strong>
</div>

<div id="map" style="width:100%;height:400px;"></div>

<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=94i46pyx3o&submodules=geocoder"></script>
<script type="text/javascript">

var items;

var dong = '${sessionScope.user_location.dong}'

console.log(dong)

var want = dong.split(" ")

console.log(want)

naver.maps.Service.geocode({
    address: '${apt_detail.road_name} ${apt_detail.road_num}'
}, function(status, response) {
    if (status !== naver.maps.Service.Status.OK) {
        return alert('Something wrong!');
    }
    
    var result = response.result, // 검색 결과의 컨테이너
        items = result.items; // 검색 결과의 배열
    
    for(step = 0; step < items.length;step++){
    	if(items[step].addrdetail.sido == want[0] && items[step].addrdetail.sigugun == want[1]){
    		var want_num = step;
    	}
    }
    console.log(want_num)
    
    console.log(items)
    console.log(items[1])
    console.log(items[want_num].point.x) // y좌표
    console.log(items[want_num].point.y) // x좌표
    // do Something
  
    var xPosition = items[want_num].point.y;
    var yPosition = items[want_num].point.x;
    console.log("xPosition : ",xPosition);
    console.log("yPosition : ",yPosition);
    
    map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(xPosition, yPosition),
        zoom: 16
    }); 
    
    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(xPosition, yPosition),
        map: map
    });
    
    
});

    
    
    
</script>


</div>

</body>
</html>