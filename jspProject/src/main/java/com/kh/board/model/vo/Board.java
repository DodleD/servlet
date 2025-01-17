package com.kh.board.model.vo;

public class Board {
	private int boardNo;
	private int boradType;
	private String category; //작성기능 사용 시 -> 카테고리번호 | 조회 카테고리명 할때
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int count;
	private String createDate;
	private String status;
	
	public Board() {
		super();
	}
	public Board(int boardNo, int boradType, String category, String boardTitle, String boardContent,
			String boardWriter, int count, String createDate, String status) {
		super();
		this.boardNo = boardNo;
		this.boradType = boradType;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
	}
	
	
	
	public Board(int boardNo, String category, String boardTitle, String boardContent, String boardWriter, String createDate) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
	}
	public Board(int boardNo, String category, String boardTitle, String boardWriter, int count, String createDate) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.count = count;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boradType=" + boradType + ", category=" + category + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardWriter=" + boardWriter + ", count=" + count
				+ ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoradType() {
		return boradType;
	}
	public void setBoradType(int boradType) {
		this.boradType = boradType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
