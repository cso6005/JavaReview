
package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class DButil {
	static Properties pros = new Properties();
	
	
	static {
		try {
			pros.load(new FileInputStream("C:\\backendCLASS\\08.java\\step10_JDBCMVC\\src\\util\\db.properties"));
	
			Class.forName(pros.getProperty("driver"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void m() {
		// 확인
			System.out.println(pros.getProperty("driver"));
	}
	
	
	
	// uri, id, pw 등으로 접속하는 객체 반환 - connection
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(pros.getProperty("url"), pros.getProperty("id"), pros.getProperty("pw"));
		
	}
	
	//자원반환 : select
		public static void close(Connection conn, Statement stmt, ResultSet rset) {
			try {
				if(rset != null) {
					rset.close();
					rset = null;
				}
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			}catch (SQLException e) {  
				e.printStackTrace();
			}
		}
		
		//자원반환 : insert.update.delete
		public static void close(Connection conn, Statement stmt) {
			try {			
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			}catch (SQLException e) {  
				e.printStackTrace();
			}
		}
	

}
