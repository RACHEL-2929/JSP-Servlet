package com.ohgiraffers.parameter.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import org.apache.naming.java.javaURLContextFactory;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		int age= Integer.parseInt(request.getParameter("age"));
		System.out.println("나이 : " + age);
		
//		날짜가 문자열로 되어있어서 형변환을 해줌 변환해줄 자료형이 java.sql.Date 이고 형변환할 때 2가지 방법이 있었음
//		parse 함수를 쓰거나 아니면 valueOf 함수를 사용해줬음
		java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
		System.out.println("생일 : " + birthday);
		
		String gender = request.getParameter("gender");
		System.out.println("성별 : " + gender);
		
		String national = request.getParameter("national");
		System.out.println("국적 : " + national);
		
		
		String[] hobbies = request.getParameterValues("hobbies");
		System.out.println("취미 : ");
		for (String hobby : hobbies) {
			System.out.println(hobby + " ");
		}
		
	}

}
