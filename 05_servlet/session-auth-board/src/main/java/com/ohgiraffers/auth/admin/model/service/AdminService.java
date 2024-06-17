package com.ohgiraffers.auth.admin.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ohgiraffers.auth.admin.model.dao.AdminDAO;
import com.ohgiraffers.auth.admin.model.dto.MemberDTO;
import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;

public class AdminService {
	
	// TODO 3. AdminDAO를 필드로 선언
	private AdminDAO adminDAO;
	
	// TODO 4. SqlSession을 얻어 AdminDAO를 통해 MemberDTO 리스트 반환받기
	public List<MemberDTO> showMemberAll(){
		SqlSession session = getSqlSession();
		adminDAO = session.getMapper(AdminDAO.class);
		List<MemberDTO> members = adminDAO.selectMemberAll();
		session.close();
		// TODO 7. 반환받은 memberList를 컨트롤러에게 반환하기
		return members;
	}
	

}
