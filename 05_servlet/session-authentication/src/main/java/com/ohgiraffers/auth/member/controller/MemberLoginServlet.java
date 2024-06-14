package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ohgiraffers.auth.member.model.dto.MemberDTO;
import com.ohgiraffers.auth.member.model.service.MemberService;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/auth/login.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");//내가 입력받은 id
		String memberPwd = request.getParameter("memberPwd");//내가 입력받은 pwd
		
		System.out.println("[MemberLoginServlet]memberId: "+memberId);
		System.out.println("[MemberLoginServlet]memberPwd: "+memberPwd);
		
		//내가 입력받은 정보들 객체에 넣어줌
		MemberDTO requestMember = new MemberDTO();
		requestMember.setMemberId(memberId);
		requestMember.setMemberPwd(memberPwd);
		
		//입력받은 정보가 있는 객체를 서비스의 로그인체크하는 메소드로 가서
		MemberDTO loginMember = new MemberService().loginCheck(requestMember);
		System.out.println("[MemberLoginServlet]loginMember: "+loginMember);
		
//		잘 받아왔다면 (로그인에 성공했다면)
		if(loginMember!=null) {
//			세션에 loginMember 넣어주기
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("message", "로그인에 실패하였습니다 :(");
			request.setAttribute("code", "login");
			request.getRequestDispatcher("/WEB-INF/views/auth/fail.jsp").forward(request, response);
		}
	}

}
