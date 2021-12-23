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

</script>



</head>
<body>

<%@ include file = "/WEB-INF/views/menu.jsp" %>

<div style="width: 85%;padding-left: 15%; ">

<h1>${MSG}</h1>
<br>
<h1> ${apt_detail.apt}</h1>
<div align="right">
<strong>최저 : ${apt_detail.min_price}</strong>
<strong>최고 : ${apt_detail.max_price}</strong>
<strong>평균 : ${apt_detail.avg_price}</strong>
</div>

<div id="map" style="width:100%;height:400px;"></div>

<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=94i46pyx3o&submodules=geocoder"></script>
<script type="text/javascript">

var items;

var dong = '${dong.dong}'

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
    
    for(i = 0; i < items.length; i++){
    	if(items[i].addrdetail.sido == want[0] && (items[i].addrdetail.sigugun == want[1] || items[i].addrdetail.sigugun == want[1]+" "+want[2] )){
    		var want_num = i;
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