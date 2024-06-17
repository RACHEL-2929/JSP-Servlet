package com.ohgiraffers.auth.member.model.dto;

import java.sql.Date;

public class BoardDTO {
	
	// TODO LV.2 > ST.1 > 1++. TBL_BOARD의 모든 컬럼 값을 받아오는 DTO 작성
	// 즉, boardNo, 제목, 내용, 글쓴이, 작성일, 수정일, 보드 상태 모두 받는 DTO
	private int boardNo;
	private String boardTitle;
	private String boardBody;
	private String writerMemberNo;
	private Date createdDate;
	private Date modifiedDate;
	private char boardStatus;
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int boardNo, String boardTitle, String boardBody, String writerMemberNo, Date createdDate,
			Date modifiedDate, char boardStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardBody = boardBody;
		this.writerMemberNo = writerMemberNo;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.boardStatus = boardStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardBody() {
		return boardBody;
	}

	public void setBoardBody(String boardBody) {
		this.boardBody = boardBody;
	}

	public String getWriterMemberNo() {
		return writerMemberNo;
	}

	public void setWriterMemberNo(String writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public char getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(char boardStatus) {
		this.boardStatus = boardStatus;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardBody=" + boardBody
				+ ", writerMemberNo=" + writerMemberNo + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", boardStatus=" + boardStatus + "]";
	}

	
	
}
