package model.dto;

import java.sql.Timestamp;

public class ReservateDTO {
	private String userName;
	private int carCode,totalPrice;
	private Timestamp reserveStart,reserveEnd;
	
	public ReservateDTO(String userName, int carCode, Timestamp reserveStart, Timestamp reserveEnd, int totalPrice) {
		this.userName=userName;this.carCode=carCode;this.reserveStart=reserveStart;this.reserveEnd=reserveEnd;this.totalPrice=totalPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getReserveStart() {
		return reserveStart;
	}

	public void setReserveStart(Timestamp reserveStart) {
		this.reserveStart = reserveStart;
	}

	public Timestamp getReserveEnd() {
		return reserveEnd;
	}

	public void setReserveEnd(Timestamp reserveEnd) {
		this.reserveEnd = reserveEnd;
	}
	
	
}
