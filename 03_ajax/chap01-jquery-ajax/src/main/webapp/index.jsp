<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Ajax</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>jQuery를 이용해 AJAX 요청 후 stream을 이용한 문자열 응답</h1>
	
	<h3>1. 데이터 전송 없이 문자열 반환</h3>
	<button id="send-no-date">SEND</button>
	<script>
		$("#send-no-date").click(function(){
			$.ajax({
				url:"/chap01/receive",//요청 보낼 곳
				type:"get",// 어떤 방식
				success: function(data){
					//성공시 수행되는 함수
					alert(data);
				},
				error: function(error){
					//에러시 수행되는 함수
					consol.log(error);
				}// 비동기 방식은 페이지 인코딩 방식을 그대로 따르기 때문에
				// 받는 데이터가 한글인데도 깨지지 않고 나옴
			});	
		});
	</script>
	
	
	
	
	<h3>2. data로 값 전송 후 문자열 반환</h3>
	<input type="text" id="message">
	<button id="send-with-data">Message SEND</button>
	<script>
		$("#send-with-data").click(function(){
			const messageVal = $("#message").val();
			
			$.ajax({
				url:"/chap01/receive",
				type:"post",
				data: {
					message: messageVal
				},// 객체로 보냄
				success: function(data){
					alert(data);
				},
				error: function(error){
					consol.log(error);
				}
			});	
			
		});
	</script>
	
	
	
	
	
	
	
	
</body>
</html>