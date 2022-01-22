package model.dto;

import java.sql.Timestamp;

public class CommentDTO {
	private String id,content;
	private int num, boardIdx;
	private Timestamp regDate;
	
	public CommentDTO(int num, int boardIdx, String id, Timestamp regDate, String content) {
		this.num=num;this.boardIdx=boardIdx;this.id=id;this.regDate=regDate;this.content=content;
	}
	
	public CommentDTO(int boardIdx, String id, Timestamp regDate, String content) {
		this.boardIdx=boardIdx;this.id=id;this.regDate=regDate;this.content=content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
}
