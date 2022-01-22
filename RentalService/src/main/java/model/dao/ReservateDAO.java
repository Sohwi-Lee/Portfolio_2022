package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.dto.ReservateDTO;
import util.DBManager;

public class ReservateDAO {
	private ReservateDAO() {}
	private static ReservateDAO instance = new ReservateDAO();
	public static ReservateDAO getInstance() {return instance;}
	
	private ArrayList<ReservateDTO> lists = null;
	
	private Connection conn=DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public ArrayList<ReservateDTO> getLists(){
		try {
			
			String str = "select * from reservation";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			lists = new ArrayList<>();
			while(rs.next()){
				String userName = rs.getString(1);
				int carCode = rs.getInt(2);
				Timestamp reserveS = rs.getTimestamp(3);
				Timestamp reserveE = rs.getTimestamp(4);
				int totalPrice = rs.getInt(5);
				
				lists.add(new ReservateDTO(userName,carCode,reserveS,reserveE,totalPrice));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
	
	public int addList(ReservateDTO reserve) {
		lists = getLists();
		try {
			ReservateDTO newReserve = new ReservateDTO(reserve.getUserName(),reserve.getCarCode(),reserve.getReserveStart(),reserve.getReserveEnd(),reserve.getTotalPrice());
			
			String str = "insert into reservation values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, reserve.getUserName());
			pstmt.setInt(2, reserve.getCarCode());
			pstmt.setTimestamp(3, reserve.getReserveStart());
			pstmt.setTimestamp(4, reserve.getReserveEnd());
			pstmt.setInt(5, reserve.getTotalPrice());
			pstmt.executeUpdate();
			
			lists.add(newReserve);
			return lists.size();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("추가실패");
		}
		return -1;
	}
	
	public int delReserve(int idx, String userName, int carCode, Timestamp start, Timestamp end) {
		lists = getLists();
		int delIdx = -1;
		for(int i=0;i<getLists().size();i++) {
			if(idx == i) {delIdx=i;} 	
		}
		
		if(delIdx!=-1) {
			try {
				String str="delete from reservation where userName=? and carCode=? and reserveStart=? and reserveEnd=?";
				pstmt = conn.prepareStatement(str);
				pstmt.setString(1, userName);
				pstmt.setInt(2, carCode);
				pstmt.setTimestamp(3, start);
				pstmt.setTimestamp(4, end);
				pstmt.executeUpdate();
				
				lists.remove(delIdx);
				System.out.println("removeRes.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("fail to removeRes.");
			}
			
		}
		return delIdx;
		
	}
	
}