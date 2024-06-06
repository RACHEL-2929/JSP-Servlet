<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 판매 페이지</title>
</head>
<body>
	<h1>제품 판매 프로그램</h1>
	
	<form action="price" method="post">
		<label>제품명 : </label>
		<input type="text" name="pro_name"><br>
		<label>수량 :</label>
		<input type="number" name="pro_price"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>