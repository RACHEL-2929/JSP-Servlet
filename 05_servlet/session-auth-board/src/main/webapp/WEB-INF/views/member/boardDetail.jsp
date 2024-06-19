<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>제목</td>
			<td>${requestScope.board.boardTitle}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${requestScope.board.boardWriter}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${requestScope.board.boardBody}</td>
		</tr>
	</table>
	
	<!-- 1. 상세 조회 페이지 완성하기 -->
	
	<!-- 2. 수정 버튼 추가하고 기능 추가하기 (본인이 쓴 게시물이면 수정 페이지로 이동하게 하기) -->
	<c:if test="${sessionScope.loginMember.memberNo eq requestScope.board.boardWriter}">
		<button><a href="${ pageContext.servletContext.contextPath }/board/modify">수정</a></button>
		<input type="hidden" name="requestBoardNo" value="${requestScope.board.boardNo}">
	</c:if>
	
	<!-- 3. 삭제 버튼 추가하고 기능 추가하기 (본인이 쓴 게시물이면 삭제할건지 confirm으로 물어보고 삭제하게 하기) -->
</body>
</html>