package com.ohgiraffers.auth.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ohgiraffers.auth.member.model.dto.MemberDTO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/member/*","/admin/*"})
public class AuthenticationFilter implements Filter {

	Map<String, List<String>> permitURIList;
	
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		
		adminPermitList.add("/admin/page");
		memberPermitList.add("/member/page");
		
		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		
		permitURIList.put("adminPermitList",adminPermitList );
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("allPermitList",allPermitList );
		
		
		
	}




	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hRequest = (HttpServletRequest)request;
		String uri = hRequest.getRequestURI();
		String intent = uri.replace(hRequest.getContextPath(),"");
		
		HttpSession requestSession = hRequest.getSession();
		MemberDTO loginMember = (MemberDTO) requestSession.getAttribute("loginMember");
		
		boolean isAuthorized = false;
		
		//loginMember의 객체의 값이 있다는 것은 member나 admin이다)
		if(loginMember != null) {
			
			//들어온 사람이 지금 요청한 페이지의 권한이 있는가를 boolean 형태로 파악하기
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			
			//allPermitList는 로그인화면, 회원가입화면, 로그아웃화면이 허가됨
			
			
			
			//만약 들어온 사람이(loginMember(객체)) 관리자라면("ROLE_ADMIN")
			if ("ROLE_ADMIN".equals(loginMember.getMemberRole())) {
				/*
				 * 관리자가 갈 수 있는 페이지는
				 * 1. 관리자도 로그아웃 페이지를 갈 수 있어야 하니까=>isPermitAll에 포함되어있는 /member/logout 페이지로 갈 수 있어야하고
				 * 2. 세션에 관리자라고 되어있는데 member에게만 접근이 허용된 페이지는 갈 수 없어야 하니까 !isPermitMember
				 * 
				 * 
				 * 유지보수가 가능해야 하니까
				 * 만약 페이지가 아직 완성이 안되서 관리자만 접근이 가능한 페이지였는데 페이지가 완성이 되서 모든 사용자가 볼 수 있는 페이지로 바꿔야 할 때
				 * isPermitAll페이지에서 그 uri만 한 번 넣어주면 되니까 유지보수가 좋다.
				 * 
				 * 
				 * (isPermitAdmin || isPermitAll) 둘 중 하나가 참이면 바로 뒤에 문장 실행시키지 않고 조건식 통과
				 * */
				if((isPermitAdmin || isPermitAll)&&!isPermitMember) {
					isAuthorized = true;
				}
				//멤버일 때
			}else if ("ROLE_MEMBER".equals(loginMember.getMemberRole())) {
				//위와 같은 이유로 작성됨
				if((isPermitMember || isPermitAll)&&!isPermitAdmin) {
					isAuthorized = true;
				}
			}
			
			//위에서 판명된 것으로 true인 경우(인가가 허가된 경우)
			if (isAuthorized) {
				chain.doFilter(request, response);
			}else {
				//허가된 페이지가 아니라면 에러!!
				((HttpServletResponse)response).sendError(403);
			}
			
			
		}else {
			// 로그인 하지 않은 회원(allPermitList)
			// 위에서 저장한 주소(intent)를 가지고 있는지 여부
			if(permitURIList.get("allPermitList").contains(intent)) {
				// 가지고 있는 주소였다면(권한이 있는) 그 페이지로 이동
				chain.doFilter(request, response);
			}else {
				// 안 가지고 있는 주소였다면(권한이 없는) 해당 속성들을 설정한 뒤 fail페이지로 forward 시킨다.
				request.setAttribute("Message", "로그인이 필요한 서비스입니다. 로그인 후 이용해 주세요!");
				request.setAttribute("code", "login");
				request.getRequestDispatcher("/WEB-INF/views/auth/fail.jsp").forward(request, response);
			}
		}
		
		
		
		
		
		
	}
}
