package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.ohgiraffers.auth.member.model.dto.BoardDTO;
import com.ohgiraffers.auth.member.model.service.BoardService;

@WebServlet("/member/page")
public class MemberPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO LV.2 > ST.1 > 1. BoardService의 메소드를 호출하여 boardList를 반환받기
		BoardService boardService = new BoardService();
		List<BoardDTO> boardList = boardService.showAllBoard(); 
		
		// TODO LV.2 > ST.1 > 1+. boardList를 반환받기 위한 BoardDTO 작성하기
		
		
		// TODO LV.2 > ST.1 > 6. boardList를 request의 attribute로 추가하여 포와딩하기
		// TODO LV.2 > ST.1 > 7. views/member/page.jsp 를 수정하여 조회한 게시판 목록이 보여지게 하기
		request.setAttribute("boardList",boardList );
		request.getRequestDispatcher("/WEB-INF/views/member/page.jsp").forward(request, response);
		
		
	}

}
