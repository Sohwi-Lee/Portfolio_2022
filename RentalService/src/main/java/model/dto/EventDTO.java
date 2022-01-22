package model.dto;

import java.sql.Timestamp;

public class EventDTO {
	private int no, viewCount, like;
	private String title, content;
	private Timestamp regDate;
	
	public EventDTO(int no, String title, String content, Timestamp regDate, int viewCount, int like) {
		this.no=no;this.title=title;this.content=content;this.regDate=regDate;this.viewCount=viewCount; this.like=like;
	}
	public EventDTO(String title, String content, Timestamp regDate) {
		this.title=title;this.content=content;this.regDate=regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
		
}
