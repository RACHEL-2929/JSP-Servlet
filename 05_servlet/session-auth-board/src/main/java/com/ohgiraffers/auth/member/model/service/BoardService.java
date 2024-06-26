package com.ohgiraffers.auth.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ohgiraffers.auth.member.model.dao.BoardDAO;
import com.ohgiraffers.auth.member.model.dao.MemberDAO;
import com.ohgiraffers.auth.member.model.dto.BoardDTO;
import com.ohgiraffers.auth.member.model.dto.MemberDTO;


import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;

import java.util.List;

public class BoardService {
	
	// TODO LV.2 > ST.1 > 2. BoardDAO 필드 선언
	private BoardDAO boardDAO;
	
	
	// TODO LV.2 > ST.1 > 3. BoardList를 조회하는 서비스 로직 작성
	public List<BoardDTO> showAllBoard() {
		// 3-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 3-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 3-3) 메소드 호출해서 BoardList 반환받기
		List<BoardDTO> boardList = boardDAO.selectAllBoard();
		// 3-4) 자원 반납
		session.close();
		// 3-5) boardList 반환하기
		return boardList;
	}


	
	// TODO LV.2 > ST.2 > 6. BoardDTO를 등록하는 서비스 로직 작성
	public int registBoard(BoardDTO board) {
		// 6-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 6-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 6-3) 메소드 호출해서 BoardDTO 등록하기
		int result = boardDAO.insertBoard(board);
		// 6-4) 등록 결과에 따른 commit, rollback 처리 후 자원 반납
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		// 6-5) 결과 int로 반환하기
		return result;
	}



	public BoardDTO showBoardDetail(int boardNo) {
		// TODO LV.2 > ST.3 > 5. BoardDTO를 조회하는 서비스 로직 작성
		// 5-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 5-2) mapper 얻기
		 boardDAO = session.getMapper(BoardDAO.class);
		// 5-3) 메소드 호출해서 BoardDTO 조회하기
		 BoardDTO board = boardDAO.selectBoardbyBoardNo(boardNo);
		// 5-4) 자원 반납
		 session.close();
		// 5-5) 결과 반환하기
		 return board;
		
	}



	// TODO LV.2 > ST.4 > 6. 대상 게시글 정보를 수정하는 서비스 로직 작성
	public int modifyBoard(BoardDTO board) {
		// 6-1) SqlSession 얻기
		SqlSession session = getSqlSession();
		// 6-2) mapper 얻기
		boardDAO = session.getMapper(BoardDAO.class);
		// 6-3) 메소드 호출해서 BoardDTO 넘겨주며 대상 정보 수정하기
		int result = boardDAO.modifyBoard(board);
		// 6-4) 수정 결과에 따른 commit, rollback 처리 후 자원 반납
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		// 6-5) 결과 int로 반환하기
		return result;
	}
	
	
	
	
	// TODO LV.2 > ST.5 > 5. 대상 게시글을 삭제 (board_status를 N으로 update) 서비스 로직 작성
	// 5-1) SqlSession 얻기
	// 5-2) mapper 얻기
	// 5-3) 메소드 호출해서 boardNo 넘겨주며 board_status 수정하게 하기
	// 5-4) 수정 결과에 따른 commit, rollback 처리 후 자원 반납
	// 5-5) 결과 int로 반환하기
}
