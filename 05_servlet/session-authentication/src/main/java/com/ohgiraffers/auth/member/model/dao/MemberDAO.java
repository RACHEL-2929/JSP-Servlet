package com.ohgiraffers.auth.member.model.dao;

import com.ohgiraffers.auth.member.model.dto.MemberDTO;

public interface MemberDAO {
	
	int insertMember(MemberDTO requestMember);

}
