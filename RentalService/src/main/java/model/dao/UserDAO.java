package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.dto.UserDTO;
import util.DBManager;

public class UserDAO {
	// singletone pattern
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {return instance;}
	
	private ArrayList<UserDTO> users = null;
	
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<UserDTO> getUsers() {
		try {
			String str = "select * from members";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();

			users = new ArrayList<UserDTO>();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String nick = rs.getString(4);
				String tel = rs.getString(5);
				String email = rs.getString(6);
				Timestamp regDate = rs.getTimestamp(7);

				users.add(new UserDTO(id, pw, nick, name, tel, email, regDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail to getLists");
		}

		return users;
	}
	
	public boolean checkLogin(String id, String pw) {
		users=getUsers();
		for(UserDTO user : users) {
			if(user.getId().equals(id) && user.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkUser(String id) {
		users = getUsers();
		for (UserDTO user : users) {
			if (id.equals(user.getId())) {
				return false;
			}
		}
		return true;
	}
	
	public int addUser(UserDTO user) {
		if (checkUser(user.getId())) {
			try {
				UserDTO newUser = new UserDTO(user.getId(), user.getPw(), user.getUserNick(), user.getUserName(), user.getTel(), user.getEmail(), user.getRegDate());
				String str = "insert into members values(?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(str);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPw());
				pstmt.setString(3, user.getUserNick());
				pstmt.setString(4, user.getUserName());
				pstmt.setString(5, user.getTel());
				pstmt.setString(6, user.getEmail());
				pstmt.setTimestamp(7, user.getRegDate());
				
				pstmt.executeUpdate();
				users.add(newUser);

				System.out.println("add success");
				return users.size();

			} catch (Exception e) {
				System.out.println("fail to add");
				e.printStackTrace();
			}
		}else {
			System.out.println("중복아이디입니다.");
		}

		return -1;
	}
	
	public int delUser(String id) {
		users = getUsers();
		int delIdx=-1;
		for(int i=0;i<users.size();i++) {
			if(id.equals(users.get(i).getId())) {
				delIdx=i;
			}
		}
		
		if(delIdx !=-1) {
			try {
				String str = "delete from members where id=?";
				pstmt = conn.prepareStatement(str);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
				users.remove(delIdx);
				
				System.out.println("user deleted");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("user delete fail");
			}
		}
		
		return delIdx;
	}
	
	public int updateUser(int idx, String nick, String tel, String email ,String id) {
		users = getUsers();
		try {
			String str = "update members set userNick=?, tel=?, email=? where id=?";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, nick);
			pstmt.setString(2, tel);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			
			users.get(idx).setUserNick(nick);
			users.get(idx).setTel(tel);
			users.get(idx).setEmail(email);
			
			System.out.println("update clear");
			return users.size();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update fail");
		}
		
		return -1;
	}

}
