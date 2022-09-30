package java1.ch10_예외처리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dao {

	private Connection con;			
	private PreparedStatement ps;	
	private ResultSet rs;
	private static Dao dao = new Dao();
	public static Dao getInstance() {
		return dao;
	}
	
	private Dao() {
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mmth",
					"root",
					"1234");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
	public void signup() throws SQLException{
		String sql = "";
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
	
	public void login() throws SQLException{
		String sql = "";
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
	
	
	
	
	
	
	
}
