<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>price forward</title>
</head>
<body>
	<h1>주문서 페이지</h1>
	주문하신 상품은 : ${ requestScope.pro_name } 이며,<br>
	상품 수량은 : ${ requestScope.pro_count }입니다.<br>
	결제하실 금액은 : ${(requestScope.pro_count) * (requestScope.pro_price)}입니다.
	
	<!--카드 종류 3가지 카드 번호 입력 받기  -->
	<h3>카드번호 종류와 카드 번호를 입력해주세요.</h3>
	<form action="views/discount.jsp" method="post">
		<label>카드종류</label><br>
		<select name="card_name" id="card_name">
			<option value="woori">우리</option>
			<option value="kb">국민</option>
			<option value="kakao">카카오</option>
		</select>
		
		<br>
		
		<label>카드번호 :</label>
		<input type="text" name="card_number"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>