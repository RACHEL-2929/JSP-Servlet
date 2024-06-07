package com.ohgiraffers.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookiesession")
public class Servlet333 extends HttpServlet {

	
	  protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException { //cookie에 카드사 카드번호 담기 
		  String cardCompany="카드회사"; 
		  String cardNumber="11122223334444";
	  
//	  [쿠키 사용법] 1. 쿠키를 생성한다. 2. 생성한 쿠키의 만료 시간을 설정한다. 3. 응답 헤더에 쿠키를 담는다. 4. 응답을 보낸다.
	  
	  
		  //1. 쿠키 생성 
		  Cookie cardCompanyCookie = new Cookie("cardCompany",cardCompany);
		  Cookie cardNumberCookie = new Cookie("cardNumber",cardNumber); 
		  //2. 쿠키 만료 시간 설정 
		  cardCompanyCookie.setMaxAge(60*60); 
		  cardNumberCookie.setMaxAge(60*60);
		  //3. 응답헤더에 쿠키 담기 
		  response.addCookie(cardCompanyCookie);
		  response.addCookie(cardNumberCookie); 
		  //4. 응답 보내기
		  response.sendRedirect("card");
	  
	  
	  }
	 
}
