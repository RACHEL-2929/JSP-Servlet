package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ohgiraffers.auth.member.model.dto.BoardDTO;
import com.ohgiraffers.auth.member.model.service.BoardService;

//TODO LV.2 > ST.4 > 1. 요청 매핑하기 
@WebServlet("/board/modify")
public class BoardModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO LV.2 > ST.4 > 3. 수정 페이지로 포와딩 시키기 (views/member/boardModify.jsp)
		int boardNo = Integer.valueOf(request.getParameter("requestBoardNo"));
		System.out.println(boardNo);
		BoardDTO board = new BoardService().showBoardDetail(boardNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/boardModify.jsp");
		rd.forward(request, response);
		//TODO LV.2 > ST.4 > 3+. 수정 페이지(views/member/boardModify.jsp) 완성시키기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO LV.2 > ST.4 > 4. request에서 수정 파라미터를 꺼내서 DTO로 뭉쳐주기
		String title = (String)request.getAttribute("requestBoardTitle");
		String body = (String)request.getAttribute("requestBoardBody");
		String writer = (String) request.getAttribute("requestBoardWriter");
		BoardDTO board = new BoardDTO(title,body,writer);
		//TODO LV.2 > ST.4 > 5. BoardService의 메소드를 호출하여 게시글 수정하기
		int result = new BoardService().modifyBoard(board);
		//TODO LV.2 > ST.4 > 9. 상세 조회 서블릿 호출로 redirect 시키기
		if(result>0) {
			response.sendRedirect("${pageContext.servletContext.ContextPath}/board/detail");
		}
	}

}
