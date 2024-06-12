<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Object Receive</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>AJAX 요청 후 stream을 이용한 JSON 응답 (toString overriding)</h1>
	
	<!--객체 하나만  -->
	<h3>1. 데이터 전송 없이 JSON 반환</h3>
	<button id="send-get-1">SEND</button>
	<script>
		$("#send-get-1").click(function () {
			$.ajax({
				url:"/chap03/receive/override",
				type:"get",
				success: function (data) {
					console.table(data);
				},
				error: function (error) {
					console.log(error);
					
				}
			});
		});
	</script>
		
		
	<!--List 형식으로 전달받기 때문에 []형태로 전달받기 때문에 정상작동-->
	<h3>2. 데이터 전송 없이 JSonArray 반환</h3>
	<button id="send-get-2">SEND</button>
	<script>
		$("#send-get-2").click(function () {
			$.ajax({
				url:"/chap03/receive/list",
				type:"get",
				success: function (data) {
					console.table(data);
				},
				error: function (error) {
					console.log(error);
					
				}
			});
		});
	</script>
	
	<!-- Map 형식으로 전달받아서 키=값 형태로 전달받아서 오류 toString으로 바꿔서 전달받으면 정상출력  -->
	<h3>3. 데이터 전송 없이 hashMap 반환</h3>
	<button id="send-get-3">SEND</button>
	<script>
		$("#send-get-3").click(function () {
			$.ajax({
				url:"/chap03/receive/map",
				type:"get",
				success: function (data) {
					console.table(data);
				},
				error: function (error) {
					console.log(error);
				}
			});
		});
	</script>
	
	
</body>
</html>