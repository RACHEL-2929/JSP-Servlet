package com.ohgiraffers.filterwrapper.section02.uses;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

//감싸고 싶은 대상을 인자로 받게 되어있다.
public class RequestWrapper extends HttpServletRequestWrapper{

	public RequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	// 함수를 다르게 썼거나 인자를 다르게 썼을 때 컴파일러에서 알아차리도록 @Override을 써줌
	@Override
	public String getParameter(String name) {
		String value="";
		
		//암호화하기 위해서
		if("password".equals(name)) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(name));
		}else {
			value = super.getParameter(name);
		}
		
		return value;
		
	}
	
	
}
