<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--설정해둔 context root : understand로 접속시 보이는 화면  -->


	<!--하이퍼링크 속성을 통해서 Service() 메소드를 호출해보기  -->
	<h1>하이퍼링크 이용하기</h1>
	<a href="understand-service">하이퍼링크로 Service() 호출하기</a>


	<!-- form 태그로 method 방식을 지정해서도 사용가능함  -->
	<h1>오버라이딩한 doGet과 doPost 사용</h1>
	<form action="understand-service" method="get">
		<input type="submit" value="GET 방식 요청">
		<!-- 버튼 생성 버튼위에 글씨 value -->
	</form>

	<br>

	<form action="understand-service" method="post">
		<input type="submit" value="POST 방식 요청">
	</form>

</body>
</html>