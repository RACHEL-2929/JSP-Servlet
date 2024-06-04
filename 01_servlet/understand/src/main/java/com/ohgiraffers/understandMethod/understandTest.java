package com.ohgiraffers.understandMethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/understand/understand-service를 입력하면
@WebServlet("/understand-service")
public class understandTest extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet과 doPost 방식을 쓰지 않고 메소드로 호출해보기
		String httpMethod = request.getMethod();
		// System.out.println("눌러진 http Mehtod 방식은 " + httpMethod);

		if ("GET".equals(httpMethod)) {
			doGet(request, response);
		} else if ("POST".equals(httpMethod)) {
			doPost(request, response);
		}
	}

	// 오버라이딩을 통해 doGet과 doPost 방식을 쓰기

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("오버라이딩한 doGet을 통해 호출됨");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("오버라이딩한 doPost를 통해 호출됨");
	}

}
