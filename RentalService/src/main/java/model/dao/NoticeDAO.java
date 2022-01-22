package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.dto.NoticeDTO;
import util.DBManager;

public class NoticeDAO {
	private NoticeDAO() {}
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	private ArrayList<NoticeDTO> noticeLists = null;
	
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	
	public ArrayList<NoticeDTO> getLists(){
		try {
			String str = "select * from noticeboard";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			noticeLists = new ArrayList<>();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				Timestamp regDate = rs.getTimestamp(4);
				int viewCount = rs.getInt(5);
				int like = rs.getInt(6);
				noticeLists.add(new NoticeDTO(num,title,content,regDate,viewCount,like));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return noticeLists;
	}
	
	public int addList(NoticeDTO board) {
		noticeLists = getLists();
		try {
			NoticeDTO newBoard = new NoticeDTO(board.getNo(), board.getTitle(), board.getContent(), board.getRegDate(), board.getViewCount(),0);
			
			String str="insert into noticeboard values(default,?,?,?,0,0)";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setTimestamp(3, board.getRegDate());
			pstmt.executeUpdate();
			
			noticeLists.add(newBoard);
			return noticeLists.size();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("notice update Failed");
		}
		return -1;
	}
	
	public int delLists(int idx) {
		noticeLists = getLists();
		
		try {
			String str="delete from noticeboard where no=?";
			pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
			noticeLists.remove(idx);
			return noticeLists.size();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public void setLikeCount(int idx) {
		noticeLists = getLists();
		int cnt = noticeLists.get(idx).getLike();
		int boardNo = noticeLists.get(idx).getNo();
		try {
			cnt+=1;
			String likeUp="update noticeboard set likes=? where no=?";
			pstmt = conn.prepareStatement(likeUp);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, boardNo);
			pstmt.executeUpdate();
			noticeLists.get(idx).setLike(cnt);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("좋아요실패");
		}
	}
	
	public void setViewCount(int idx) {
		noticeLists = getLists();
		int cnt = noticeLists.get(idx).getViewCount();
		int boardNo = noticeLists.get(idx).getNo();
		try {
			cnt+=1;
			String viewUp="update noticeboard set viewCount=? where no=?";
			pstmt = conn.prepareStatement(viewUp);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, boardNo);
			pstmt.executeUpdate();
			noticeLists.get(idx).setViewCount(cnt);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회업데이트실패");
		}
	}
	
}
