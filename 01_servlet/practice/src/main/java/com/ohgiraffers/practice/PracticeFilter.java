package com.ohgiraffers.practice;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter("/price")
public class PracticeFilter extends HttpFilter implements Filter {
       
    public PracticeFilter() {
    	//기본 생성자
    }

	public void destroy() {
		//톰캣 서버 꺼지면 호출됨
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("제품명 : "+request.getParameter("pro_name"));
		System.out.println("수량 : "+request.getParameter("pro_count"));
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
