package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import model.dto.EventDTO;
import util.DBManager;

public class EventDAO {

	private EventDAO() {}
	private static EventDAO instance = new EventDAO();
	public static EventDAO getInstance() {return instance;}
	
	private ArrayList<EventDTO> eventLists = null;
	
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public ArrayList<EventDTO> getLists(){
		try {
			String str = "select * from eventboard";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			eventLists = new ArrayList<>();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				Timestamp regDate = rs.getTimestamp(4);
				int viewCount = rs.getInt(5);
				int like = rs.getInt(6);
				eventLists.add(new EventDTO(num,title,content,regDate,viewCount,like));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return eventLists;
	}
	
	public int addList(EventDTO board) {
		try {
			EventDTO newBoard = new EventDTO(board.getNo(), board.getTitle(), board.getContent(), board.getRegDate(), board.getViewCount(), 0);
			
			String str="insert into eventboard values(default,?,?,?,0,0)";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setTimestamp(3, board.getRegDate());
			pstmt.executeUpdate();
			
			eventLists.add(newBoard);
			return eventLists.size();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("event update Failed");
		}
		return -1;
	}
	
	public int delLists(int idx) {
		eventLists = getLists();
		
		try {
			String str="delete from eventboard where no=?";
			pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
			eventLists.remove(idx);
			return eventLists.size();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int updateBoard(String title, String content, int num) {
		eventLists = getLists();
		int upIdx = -1;
		for(int i=0;i<eventLists.size();i++) {
			if(i == num) {
				upIdx = num;
			}
		}
		if(upIdx!=-1) {
			try {
				String upStr="update eventboard set title=?, content=? where no=?";
				pstmt = conn.prepareStatement(upStr);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, eventLists.get(num).getNo());
				pstmt.executeUpdate();
				eventLists.set(upIdx, new EventDTO(title, content, new Timestamp(Calendar.getInstance().getTimeInMillis())));
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("수정실패");
			}
		}
		return upIdx;
	}
	
	public void setLikeCount(int idx) {
		eventLists = getLists();
		int cnt = eventLists.get(idx).getLike();
		int boardNo = eventLists.get(idx).getNo();
		try {
			cnt+=1;
			String likeUp="update eventboard set likes=? where no=?";
			pstmt = conn.prepareStatement(likeUp);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, boardNo);
			pstmt.executeUpdate();
			eventLists.get(idx).setLike(cnt);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("좋아요실패");
		}
	}
	
	public void setViewCount(int idx) {
		eventLists = getLists();
		int cnt = eventLists.get(idx).getViewCount();
		int boardNo = eventLists.get(idx).getNo();
		try {
			cnt+=1;
			String viewUp="update eventboard set viewCount=? where no=?";
			pstmt = conn.prepareStatement(viewUp);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, boardNo);
			pstmt.executeUpdate();
			eventLists.get(idx).setViewCount(cnt);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회업데이트실패");
		}
	}
	
	
}
