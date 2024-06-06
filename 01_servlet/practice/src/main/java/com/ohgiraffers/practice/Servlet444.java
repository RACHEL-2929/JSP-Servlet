package com.ohgiraffers.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("card")
public class Servlet444 extends HttpServlet {
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * String cardCompany = ""; String cardNumeber = "";
	 * 
	 * Cookie[] cookies = request.getCookies(); for (int i = 0; i < cookies.length;
	 * i++) { if ("cardCompany".equals(cookies[i].getName())) { cardCompany =
	 * cookies[i].getName(); }else if("cardNumber".equals(cookies[i].getName())) {
	 * cardNumeber = cookies[i].getName(); } }
	 * 
	 * System.out.println("카드번호 : " + cardNumeber + "(카드사: " + cardCompany + ")" +
	 * "로 결제되었습니다.");
	 * 
	 * }
	 */
}
