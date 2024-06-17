<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>🎠🎠 사용자 전용 페이지 입니다! 🎠🎠</h3>
	<hr>
	<h1>사용자 자유게시판</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>

		<!-- (LV.2 > ST.1) 1. EL, JSTL 활용해서 목록 현출되게 하기  -->
	<c:forEach items="${requestScope.boardList }" var="board">
	
	
	<!-- (LV.2 > ST.3) 3. script로 onclick 이벤트를 걸어 상세조회 요청하게 하기 -->
	<script>
		let tr = document.getElementByclassName("boardDetail");
		tr.addEventListener("click", function(){
			location.href="${pageContext.servletContext.contextPath}/board/detail?boardNo=${board.boardNo}";
		});
	
	</script>
	
	
	
		<tr class="boardDetail">
			<th>${board.boardNo }</th>
			<th>${board.boardTitle }</th>
			<th>${board.boardWriter }</th>
			<th>${board.createdDate }</th>
		</tr>
	</c:forEach>
	</table>
	
<!-- 	<script>
    document.addEventListener("DOMContentLoaded", function() {
        let rows = document.querySelectorAll(".boardDetail");
        rows.forEach(function(row) {
            row.addEventListener("click", function() {
                let boardNo = this.getAttribute("data-board-no");
                location.href = `${pageContext.servletContext.contextPath}/board/detail?boardNo=${boardNo}`;
            });
        });
    });
</script> -->
	
	<!-- (LV.2 > ST.2) 2. 등록 버튼을 추가하여 게시글 등록 페이지로 이동하게 하기 (servlet get요청) -->
	<button><a href= "${pageContext.servletContext.contextPath }/board/regist">등록</a></button>
	



</body>
</html>