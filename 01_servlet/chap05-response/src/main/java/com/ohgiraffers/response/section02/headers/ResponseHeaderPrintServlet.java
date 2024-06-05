package com.ohgiraffers.response.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Iterator;


@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 응답 ContentType 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 응답 stream 얻어오기
		PrintWriter out = response.getWriter();
		
		out.print("<h1>현재 시간은 </h1>" + System.currentTimeMillis() +"입니다.</h1>");
		
//		System.out.println(System.currentTimeMillis());
		
		//out.close()를 뒤에 쓰면 sysout 안나옴 ???
		
		out.close();

		
		Collection<String> responseHeaders = response.getHeaderNames();
		Iterator<String> iter = responseHeaders.iterator();
		
		while (iter.hasNext()) {
			String headerName = iter.next();
			System.out.println(headerName + ": " + response.getHeader(headerName));
			
		}
		
		
		
	
	}

}
