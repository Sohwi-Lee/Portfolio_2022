package model.dto;

public class ReviewDTO {
	private String userName,content,reservedCar;
	private int score;
	
	public ReviewDTO(String userName, String reserved, String content, int score) {
		this.userName=userName;this.content=content;this.reservedCar=reserved;this.score=score;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReservedCar() {
		return reservedCar;
	}

	public void setReservedCar(String reservedCar) {
		this.reservedCar = reservedCar;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
