package com.ohgiraffers.section01.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

import com.ohgiraffers.model.dto.MemberDTO;

@WebServlet("/receive/simple")
public class ReceiveSimpleJsonObjectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO("get","squeirrel","nam",200);
		
		
		JSONObject json = new JSONObject();
		json.put("type", member.getType());
		json.put("firstName", member.getFirstName());
		json.put("lastName", member.getLastName());
		json.put("height", member.getHeight());
		
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(json);
		out.close();
	
	}

}
