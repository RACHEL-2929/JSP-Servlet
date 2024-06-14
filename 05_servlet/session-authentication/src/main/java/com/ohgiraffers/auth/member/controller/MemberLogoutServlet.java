package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/logout")
public class MemberLogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 무효화
		request.getSession().invalidate();
		
		response.sendRedirect(request.getContextPath());//main페이지로 간다
	
	
	}

}
