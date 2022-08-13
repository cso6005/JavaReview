/** 실습 2단계 - 리뷰**/
/** 모든 db 연동 클래스의 각각의 메소드들의 공통된 코드를 분리한 코드**/

package Util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class DBUtil {
	
	/** properties 파일의 내용을 보유하게 되는 객체 생성 **/
	static Properties pros = new Properties();
	
	/** driver loading **/
	static {
		try {
			pros.load(new FileInputStream("C:\\backendCLASS\\08.java\\step99_Review_JDBC\\src\\db.properties"));
			Class.forName(pros.getProperty("driver"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** driver loading 확인하는 메소드 **/
	//@Test
	public void m() {
			System.out.println(pros.getProperty("driver"));
	}
	
	
	/** connection 
	 * @throws SQLException **/
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(pros.getProperty("url"), pros.getProperty("id"), pros.getProperty("pw"));		
	}
	
	/** close - DQL **/
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
	
	/** close - DML **/
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
