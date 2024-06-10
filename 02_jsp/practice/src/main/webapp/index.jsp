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
		<select name="pro_name" id="pro_name">
			<option value="chair">의자</option>
			<option value="desk">책상</option>
			<option value="bed">침대</option>
		</select>
		
		<br>
		
		<label>수량 :</label>
		<input type="number" name="pro_count"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>