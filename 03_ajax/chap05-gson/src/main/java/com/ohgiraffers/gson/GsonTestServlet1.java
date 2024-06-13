package com.ohgiraffers.gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.ohgiraffers.mode.dto.MemberDTO;

@WebServlet("/gson/test1")
public class GsonTestServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = new MemberDTO("M01","다람쥐",'여',900);
		
		
		Gson gson = new Gson();
		
		// 객체를 json으로 
		// toJSon() : java 객체를 json 문자열로 반환
		String jsonString = gson.toJson(member);// json 형태로 바꿔서 문자열을 반환
		System.out.println(jsonString);
		
		// json을 원하는 객체의 형태로
		// 어떤 json 형태를 바꿀건지의 인자, 어떤 객체로 바꿀건지의 인자
		MemberDTO jsonMember = gson.fromJson(jsonString, MemberDTO.class);
		System.out.println(jsonMember);
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.close();
	
	}

}
