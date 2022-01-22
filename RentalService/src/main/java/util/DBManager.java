package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	
	private DBManager() {}
	
	// 모든 DAO안에서 DB연동이 필요할 때
	// DBManager.getConnection();으로 연결되도록!
	
	// 연동된 DB(Schema) 안에 있는 데이터 중
	// 어떤 테이블을 사용할지 >> use 스키마명 << sql문 추가
	
	public static Connection getConnection() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/car_rental?serverTimezone=UTC";
			String id = "root";
			String pw = "dlthgnl";

			conn = DriverManager.getConnection(url, id, pw);
			if (conn == null) {
				System.out.println("no연동");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연동 XX");
		}

		return conn;

	}

}
