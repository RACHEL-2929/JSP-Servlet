<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 판매 페이지</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>제품 판매 프로그램</h1>
	
	
		<h2><label>제품명</label></h2>
		<select name="pro_name" id="pro_name">
			<option value="chair">의자</option>
			<option value="desk">책상</option>
			<option value="bed">침대</option>
		</select>
		
		<br>
		
		<h2><label>수량</label></h2>
		<input type="number" name="pro_count" id="pro_count"><br>
		<input type="submit" value="전송" id="submit">
		<br>
		<h3>총 상품 금액은 </h3><h3 id="total_price"></h3><h3>원 입니다.</h3>
		
		<script>
			let price = 0;
			$("#submit").click(function() {
				$.ajax({					
					url:"/practice/totalprice",
					type:"get",
					data:{
						pro_count:$("#pro_count").val(),
						pro_name:$("#pro_name").val()
					},
					success:function(data){
						/*넘어온 것은 객체이므로 접근하려면 .을 사용해야 한다.  */
						price = data.price;
						$("#total_price").text(price);
					},
					error: function(error) {
						console.log(error);
					}
				});
			});
		</script>
		<hr>
		<h3>카드 종류와 카드 번호를 입력해주세요</h3>
		<h2><label>카드 종류</label></h2>
		<select name="card_name" id="card_name">
			<option value="woori">우리카드</option>
			<option value="kb">국민카드</option>
			<option value="kakao">카카오카드</option>
		</select>
		<h3 id="discount"></h3>
		<br>
		<h2><label>카드 번호</label></h2>
		<input type="text" name="card_num" id="card_num">
		<input type="submit" name="submit" id="submit2">
		<br>
		<h2 id="discountComplete"></h2>
		<script>
			let discount = 0;
			$("#card_name").change(function() {
				console.log($("#card_name").val());
				$.ajax({
					url:"/practice/cardiscount",
					type:"get",
					data:{
						card_name:$("#card_name").val(),
					},
					success: function(data) {
						discount = data.discount;
						$("#discount").text("카드 할인율 " + discount +"%가 적용되었습니다.");
					},
					error: function(error) {
						console.log(error);
					}
				});
			});
		</script>
		
		<script>
 			$("#submit2").click(function() {
				$.ajax({
					url:"/practice/success",
					type:"get",
					data:{
						card_name:$("#card_name").val(),
						price:price,
						discount:discount
					},
					success: function(data) {
						$("#discountComplete").text($("#card_name option:selected").text()+"로 "+
								"총 " + data.discountPrice+"원 결제되었습니다!! :)");
					},
					error: function(error) {
						console.log(error);
					}
				});
			});
		</script>
		
	
</body>
</html>