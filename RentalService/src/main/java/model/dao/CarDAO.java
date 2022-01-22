package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.CarDTO;
import util.DBManager;

public class CarDAO {
	private CarDAO() {}
	private static CarDAO instance = new CarDAO();
	public static CarDAO getInstance() {return instance;}
	
	private ArrayList<CarDTO> cars = null;
	
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	public ArrayList<CarDTO> getLists(){
		try {
			String str = "select * from cars";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			cars = new ArrayList<CarDTO>();
			
			while(rs.next()) {
				int code = rs.getInt(1);
				String name = rs.getString(2);
				String size= rs.getString(3);
				String fuel= rs.getString(4);
				int release= rs.getInt(5);
				int price = rs.getInt(6);
				String img = rs.getString(7);
				cars.add(new CarDTO(code,name,size,fuel,release,price,img));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}
}
