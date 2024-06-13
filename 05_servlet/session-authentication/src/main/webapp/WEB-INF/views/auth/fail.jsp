<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert('${ requestScope.message}');
		
		window.location.replace('${ pageContext.servletContext.contextPath }/member/regist');
	</script>
</body>
</html>