package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	Connection con;			// DB연동 인터페이스
	PreparedStatement ps;	// SQL 조작 인터페이스
	ResultSet rs;			// 쿼리 결과 조작 인터페이스
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(		// 실제로 연결해주는 문법
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234");
			System.out.println(" DB 연동 성공");		
		} catch (Exception e) {
			System.out.println(" DB 연동 실패 : "+e);
		}
	}
	
	
	
	
	
	
} // Dao 종료
