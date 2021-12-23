<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지금 우리 동네는</title>
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/4/40/Home_Icon_by_Lakas.svg">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script type="text/javascript">



$("#userpw").keyup(function(e) {
    console.log("키업!");
	var content = $(this).val();
	$("#pw_length").text("(" + content.length + "/ 200)"); //실시간 글자수 카운팅
	if (content.length > 200) {
		Alert("최대 200자까지 입력 가능합니다.");
		$(this).val(content.substring(0, 200));
		$('#textLengthCheck').html("(200 / 최대 200자)");
	}
});





	$(document).ready(function() {
		$("#joinBtn").click(function() {
			if ($("#userid").val() == "") {
				alert("아이디 입력!!!");
				return;
			} else if ($("#userpw").val() == "") {
				alert("비밀번호 입력!!!");
				return;
			} else if ($("#username").val() == "") {
				alert("이름 입력!!!");
				return;
			} else {
				if ($('#pwCheck').val() == $('#userpw').val()) {
					if(confirm("가입하시겠습니까??")){
						$("#joinform").attr("action", "${root}/join").submit();
					}
				} else {
					alert("비밀번호를 확인 해주세요")
					$('#pwCheck').val('');
				}
			}
		});

	});

	$(document).ready(function() {
		$("#checkBtn").click(function() {
			$.ajax({
				url : "/idCheck",
				type : "post",
				dataType : "json",
				data : {
					"id" : $("#userid").val()
				},
				success : function(data) {
					if ($("#userid").val() == "") {
						alert("아이디 입력!!!");
						return;
					} else {

						if (data == 1) {
							alert("중복된 아이디");
							$("#userid").val('');
						} else if (data == 0) {
							alert("사용 가능");
							$("#joinBtn").attr("disabled", false);
						}

					}

				}
			})

		});

	});
	
	
	
</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/menu.jsp"%>
	<br>


	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<div class="container" align="center">

		<div class="col-lg-6" align="center">
			<form id="joinform" method="post" action="">
				<!-- <div class="form-group" align="left"> -->
				<div align="left">
					<label for="">아이디</label>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="userid" name="userid" placeholder="" onkeyup="this.value=this.value.replace(/[^a-zA-Z-_0-9]/g,'');">
					<button class="btn btn-warning" id="checkBtn" type="button">중복체크</button>
				</div>

				<div class="form-group" align="left">
					<label for="">비밀번호</label> 
					<input type="password" class="form-control" id="userpw" name="userpw" maxlength="12" minlength="6">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호 체크</label> 
					<input type="password" class="form-control" id="pwCheck" name="pwCheck" maxlength="12">
				</div>
				<div class="form-group" align="left">
					<label for="">이름</label> 
					<input type="text" class="form-control" id="username" name="username" placeholder="">
				</div>
				<div align="left">
					<label for="">주소</label>
				</div>
				<div class="input-group mb-3">
					<input type="text" id="postcode" class="form-control" placeholder="우편번호" readonly="readonly">
					<button type="button" onclick="execDaumPostcode()" class="btn btn-success">주소검색</button>
				</div>
				<input type="text" id="address" class="form-control" placeholder="주소" name="road" readonly="readonly">
				<br>
				<input type="text" id="extraAddress" class="form-control" placeholder="참고항목" name="dong_apt" readonly="readonly">
				<br>
				<div class="form-group" align="center">
					<button type="button" id="joinBtn" class="btn btn-warning" disabled="disabled">회원가입</button>
				</div>
			</form>

		</div>
	</div>

	<script>
	 function execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수

	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postcode').value = data.zonecode;
	                document.getElementById("address").value = data.address;
	                /* document.getElementById("address").value = data.jibunAddress; */
	                
	                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	                if(roadAddr !== ''){
	                    document.getElementById("extraAddress").value = extraRoadAddr;
	                } else {
	                    document.getElementById("extraAddress").value = '';
	                }
	                
	                console.log(data)
	                
	            }
	        }).open();
	    }
    
</script>

</body>
</html>