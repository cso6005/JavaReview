

package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.DBUtil;
import model.domain.CustomerDTO;

public class Shopping2 {
	
	
	
	/** 1. 메소드 select1 **/
	public static void select1(int cust_id1)  throws SQLException{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from customers where cust_id in (" + cust_id1 + ")" );
			
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getString(3) + " "+ rset.getString(4)  + " "+ rset.getString(5)  + " "+ rset.getString(6)  + " "+ rset.getCharacterStream(7)  + " "+ rset.getDate(8));
				} 

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, stmt, rset);
				}
			}
	
	
	
	/** 2. 메소드 select2() **/
	public static void select2(int cust_id1, int cust_id2)  throws SQLException{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select cust_id, cust_name, join_date from customers where cust_id in (" + cust_id1 + "," + cust_id2 + ")" );
			
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getDate(3));
				} 

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, stmt, rset);
				}
			}
	
	/** 3. insertCust - Statement API 사용 **/
	/* pk 중복에 대한 예외를 처리*/
	public static boolean insertCust(CustomerDTO cust)  throws SQLException{
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();	
			
			String sql = "insert into customers values (" + cust.getCust_id() + ", '" + cust.getCust_name() + "','" + cust.getAddress() + "','" + cust.getPostal_code() + "','" + cust.getCust_email() + "','" + cust.getPhone_number() + "','" + cust.getGender() + "','" + cust.getJoin_date() + "')";
					
			System.out.println(sql);
			
			int i = stmt.executeUpdate(sql);
			
			if(i == 1 ) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stmt);
		}

		return false;
		
	}
	
	
	/** 4. select3 - PreparedStatement API 사용 **/
	public static boolean select3()  throws SQLException{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from cust");
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset);
			
			while(rset.next()) {
				System.out.println("왜");
				System.out.println(rset.getInt("cust_id") + " " + rset.getString(2) + " " + rset.getString(3) + " "+ rset.getString(4)  + " "+ rset.getString(5)  + " "+ rset.getString(6)  + " "+ rset.getCharacterStream(7)  + " "+ rset.getDate(8));
				} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
		}

		return false;
		
	}
	
	
	/** 4. insertCust - PreparedStatement API 사용 **/
	public static boolean insertCust2(CustomerDTO cust)  throws SQLException{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("insert into customers values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, cust.getCust_id());
			pstmt.setString(2, cust.getCust_name());
			pstmt.setString(3, cust.getAddress());			
			pstmt.setString(4, cust.getPostal_code());
			pstmt.setString(5, cust.getCust_email());
			pstmt.setString(6, cust.getPhone_number());
			pstmt.setObject(7, cust.getGender(), java.sql.Types.CHAR);
			pstmt.setDate(8, cust.getJoin_date());

			
			int i = pstmt.executeUpdate();
			
			if(i == 1 ) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
		}

		return false;
		
	}
	
	/** 5. deleteCust - PreparedStatement API 사용 **/
	public static boolean deleteCust(int cust_id)  throws SQLException{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("delete from customers where cust_id=?");
			
			pstmt.setInt(1, cust_id);

			
			int i = pstmt.executeUpdate();
			System.out.println(i);
			
			if(i == 1 ) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
		}

		return false;
		
	}
	
	/** 6. updateCust - PreparedStatement API 사용 **/
	public static boolean updateCust1(String cust_name, String address) throws SQLException{

		Connection conn = null;
		PreparedStatement pstmt = null; 
		
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("update cust set address=? where cust_name=?");
			
			pstmt.setString(1, address);
			pstmt.setString(2, cust_name);

			
			int i = pstmt.executeUpdate();
			
			System.out.println(i);
			
			if(i == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {//자원 반환
			DBUtil.close(conn, pstmt);

		}
		
		return false;
		
	}

	public static void main(String[] args) {

		try {

			/** select **/
			select2(100, 110);
			
			/** insert **/
			// Date date = Date.valueOf("2004-06-22");
			//insertCust(new CustomerDTO(210, "유고객", "서울시 관악구 남현동", "12342", "a@abc.com", "010-3231-1241", 'M', date));
			
			/** delete **/
			//deleteCust(190);
			
			/** update **/
			//updateCust1("박고객", "부산광역시 서구 대신동");

		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	


}
