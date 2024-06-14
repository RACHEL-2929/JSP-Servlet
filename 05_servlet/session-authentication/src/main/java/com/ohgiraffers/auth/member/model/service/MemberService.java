package com.ohgiraffers.auth.member.model.service;

import com.ohgiraffers.auth.member.model.dao.MemberDAO;
import com.ohgiraffers.auth.member.model.dto.MemberDTO;
import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;;
public class MemberService {

	private MemberDAO memberDAO;
	
	public int registMember(MemberDTO requestMember) {
		
		SqlSession session = getSqlSession();
		memberDAO = session.getMapper(MemberDAO.class);
		
		int result = memberDAO.insertMember(requestMember);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public MemberDTO loginCheck(MemberDTO requestMember) {
		//세션 생성
		SqlSession session = getSqlSession();
		//맵핑
		memberDAO = session.getMapper(MemberDAO.class);
		
		//초기화
		MemberDTO loginMember = null;
		
		//requestMember는 로그인하기 위해 받은 아아디와 비밀번호를 가진 객체
		//쿼리문으로 문자열 형태인 암호화된 비밀번호를 가지고 온다.
		String encPwd = memberDAO.selectEncryptedPwd(requestMember);
		
		//matches()를 사용하기 위해 객체 생성
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getMemberPwd(), encPwd)) {
			//회원가입이 되어있는 사람이라면 그 사람의 정보를 가지고 와서 loginMember에 넣어준다.
			loginMember = memberDAO.selectLoignMember(requestMember);
		}
		session.close();
		
		return loginMember;
	
	}

	


}
