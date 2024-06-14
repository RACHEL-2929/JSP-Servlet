package com.ohgiraffers.auth.member.model.dao;

import com.ohgiraffers.auth.member.model.dto.MemberDTO;

public interface MemberDAO {
	
	int insertMember(MemberDTO requestMember);

//	암호화된 비밀번호 가지고 오기
	String selectEncryptedPwd(MemberDTO requestMember);
//	비밀번호가 맞다면 가지고 오는 얘들
	MemberDTO selectLoignMember(MemberDTO requestMember);

}
