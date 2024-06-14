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
	// filter에서 설정한 메세지를 알람창으로 띄우기
		alert('${ requestScope.message}');
		
	//설정된 code값 꺼내서 저장하기
		const code = '${ requestScope.code }';
		//만약 그 값이 login이면
		if(code === 'login') {
			//다시 로그인 창으로 보내기
			window.location.replace('${ pageContext.servletContext.contextPath }/member/login');
		} else if(code === 'regist') {
			//login이 아니었다면 회원가입 페이지로 이동하기
			window.location.replace('${ pageContext.servletContext.contextPath }/member/regist');
		}
	</script>
</body>
</html>