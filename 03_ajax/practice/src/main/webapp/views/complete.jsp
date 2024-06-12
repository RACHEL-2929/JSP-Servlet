<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료 페이지</title>
</head>
<body>
	<h1>주문이 완료 되었습니다</h1>
	<h3>
	<c:set var="discount" value="${requestScope.discount }"/>
	<c:set var="pro_total" value="${requestScope.pro_total }"/>
	상품명 : ${requestScope.pro_name }<br>
	상품 갯수 : ${requestScope.pro_count }<br>
	상품 한 개당 가격 : ${requestScope.pro_price }<br>
	총 상품 가격 : ${ pro_total }<br>
	카드 종류 : ${requestScope.card_name }<br>
	카드 번호 : ${requestScope.card_number }<br>
	카드 할인율 : ${ discount }<br>
	<c:set var="total" value="${ (1-discount) * pro_total }"/>
	최종 결제 금액 : ${ total } <br>
	</h3>
</body>
</html>