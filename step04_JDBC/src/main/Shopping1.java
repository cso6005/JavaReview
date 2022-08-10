/** 실습 1단계 - 리뷰 **/
/** 기본 문법 리뷰 **/

/** Database - shopping ,  tables - customers **/

/*
mysql>  select cust_id, cust_name, join_date from customers where cust_id in (100,110);
+---------+-----------+------------+
| cust_id | cust_name | join_date  |
+---------+-----------+------------+
|     100 | 김고객    | 2010-10-22 |
|     110 | 이고객    | 2011-11-02 |
+---------+-----------+------------+
2 rows in set (0.00 sec)
 * */


package step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Shopping1 {
	

	public static void selectAll(int cust_id1, int cust_id2) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/shopping?characterEncoding=UTF-8&serverTimezone=UTC", "sso", "enjoy");
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select cust_id, cust_name, join_date from customers where cust_id in (" + cust_id1 + "," + cust_id2 + ")" );
			
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getDate(3));
				} 

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
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
				} catch (SQLException e) {
					e.printStackTrace();
					}
				}
			}
	
	public static void main(String[] args) {
		selectAll(100, 110);
	}
	}

