package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.ReviewDTO;
import util.DBManager;

public class ReviewDAO {
	private ReviewDAO() {}
	private static ReviewDAO instance = new ReviewDAO();
	public static ReviewDAO getInstance() {return instance;}
	
	private ArrayList<ReviewDTO> lists = null;
	
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ArrayList<ReviewDTO> getLists() {
		try {
			String str = "select * from review";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			lists = new ArrayList<>();
			
			while(rs.next()) {
				String name = rs.getString(1);
				String reserved = rs.getString(2);
				String content = rs.getString(3);
				int score = rs.getInt(4);
				
				lists.add(new ReviewDTO(name,reserved,content,score));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
	public int addList(ReviewDTO review) {
		ReviewDTO newReview = new ReviewDTO(review.getUserName(),review.getReservedCar(),review.getContent(),review.getScore());
		
		try {
			String str = "insert into review values(?,?,?,?)";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, review.getUserName());
			pstmt.setString(2, review.getReservedCar());
			pstmt.setString(3, review.getContent());
			pstmt.setInt(4, review.getScore());
			pstmt.executeUpdate();
			
			lists.add(newReview);
			return lists.size();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return - 1;
		
	}
}
