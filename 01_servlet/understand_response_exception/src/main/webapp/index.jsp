<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response and Exception</title>
</head>
<body>
<form action="response" method="post">
	<h1>주문 화면</h1>
	<label>제품명 : </label>
	<select name="name">
		<option value="chair">의자</option>
		<option value="bed">침대</option>
		<option value="desk">책상</option>
	</select>
	<br>
	<label>수량 : </label>
	<input type="number" name="count">
	<br>
	<label>의자 가격 : 90000 </label><br>
	<label>침대 가격 : 1000000 </label><br>
	<label>책상 가격 : 80000 </label><br>
	<br>
	<input type="submit" value="총 가격 알아보기">
</form>

</body>
</html>