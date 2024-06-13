package com.ohgiraffers.gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohgiraffers.mode.dto.MemberDTO;

//@WebServlet("gson/test4")
public class GsonTestServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = new MemberDTO("M01","다람쥐",'남',900,new java.sql.Date(System.currentTimeMillis()));
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")//날짜 형식 지정
				.setPrettyPrinting()//한줄로 나오는 것을 밑으로 보이게 해주는 것//JSON 문자열을 이쁘게 출력하게 함
//				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)//키 이름들을 소문자에 -가 있는 것으로
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)//필드명 명명 정책
				.serializeNulls()//null이어도 가지고 와서 null을 띄워줌(null이어도 직렬화를 해주겠다)//필드 값이 null이어도 직렬화 처리
				.disableHtmlEscaping()// html에 해당하는 <>가 나오면 태그라고 인식하겠다//직렬화 시 escape 시퀀스 처리하지 않음
				.create();
		
		String jsonString = gson.toJson(member);
		System.out.println(jsonString);
		
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("");
		out.close();
	
	
	}

}
