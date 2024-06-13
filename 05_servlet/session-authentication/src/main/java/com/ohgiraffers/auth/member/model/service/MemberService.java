package com.ohgiraffers.auth.member.model.service;

import com.ohgiraffers.auth.member.model.dao.MemberDAO;
import com.ohgiraffers.auth.member.model.dto.MemberDTO;
import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;
import org.apache.ibatis.session.SqlSession;;
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

}
