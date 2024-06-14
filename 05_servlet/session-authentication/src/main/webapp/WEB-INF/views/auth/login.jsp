<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="${pageContext.servletContext.contextPath }/member/login" method="post">
		ID: <input type="text" name="memberId"><br>
		비밀번호: <input type="password" name="memberPwd"><br>
		<button>로그인하기</button>
		<!--submit이 아니어도 버튼이 하나라도 있으면 submit이다  -->
	</form>
</body>
</html>