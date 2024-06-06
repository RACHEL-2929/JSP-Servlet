package com.ohgiraffers.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체를 공유하기 때문에 새로고침을 하면 콘솔에 계속 찍힘
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		
		//attribute는 요청쪽에서 해야함
		//앞에오는 인자는 키, 두번째는 값이다.(Map과 유사)
		//value 는 중복 가능, 키는 중복 x
		//만약 키는 같은데 다른 값을 준다면 마지막에 주는 값으로 덮어쓰기 된다.
		
		// 사용자에게 받은 값 제외하고도 더 정보를 넘겨주고 싶을 때 쓴다.
		request.setAttribute("userName", "다람쥐");
		
	
		RequestDispatcher rd = request.getRequestDispatcher("print");//forward할 서블릿의 맵핑된 URL 주소를 적어준다.
		rd.forward(request, response);//내가 받은 객체를 넣어줘서 반환한다.
		//주소창에는 forward로만 보인다. 내부적으로 보내준 거라서 주소창에는 print는 보이지 않음 
		
	}

}
