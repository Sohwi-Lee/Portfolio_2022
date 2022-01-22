package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.dto.CommentDTO;
import util.DBManager;

public class EventCommentDAO {
	private EventCommentDAO() {}
	private static EventCommentDAO instance = new EventCommentDAO();
	public static EventCommentDAO getInstance() {
		return instance;
	}
	
	private ArrayList<CommentDTO> lists = null;
	
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<CommentDTO> getLists(){
		try {
			String str="select * from eventcomment";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			lists = new ArrayList<CommentDTO>();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				int idx = rs.getInt(2);
				String id = rs.getString(3);
				Timestamp regDate = rs.getTimestamp(4);			
				String content = rs.getString(5);
				
				lists.add(new CommentDTO(num,idx,id,regDate,content));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lists;
	}
	
	public int addComment(CommentDTO com) {
		lists = getLists();
		try {
			CommentDTO newComment = new CommentDTO(com.getNum(), com.getBoardIdx(), com.getId(), com.getRegDate(),com.getContent());

			String str="insert into eventcomment values(default,?,?,?,?)";
			pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, com.getBoardIdx());
			pstmt.setString(2, com.getId());
			pstmt.setTimestamp(3, com.getRegDate());
			pstmt.setString(4, com.getContent());
			pstmt.executeUpdate();
			
			lists.add(newComment);
			
			return lists.size();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return -1;
	}
}
