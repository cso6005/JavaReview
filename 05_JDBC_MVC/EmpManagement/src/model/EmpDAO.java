/** playdate DB - emp table**/
/* 과제 내용
 * 		select * from emp;
		select * from emp where empno=?
		insert into emp values (? ? ? ? ? ? ? ?)
		update emp sal = sal*1.5 where deptno=?
		delete from emp where empno=?
 * */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.EmpDTO;
import util.DButil;

public class EmpDAO {
	
	/* 고려 사항 : 직원 정보는 EmpDTO 로 매핑 / 모든 직원 정보는 ArrayList 에 저장 */
	
	/** 모든 직원 검색 **/
	public static ArrayList<EmpDTO> selectAll() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList <EmpDTO> empList = null; // db 객체가 안 될 경우를 생각해 객체 생성은 try 에서 한다.
		
		
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement("select * from emp");
			rset = pstmt.executeQuery();
			
			empList = new ArrayList<EmpDTO>(); 

			while(rset.next()) {
				//System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getString(3) + " "+ rset.getInt(4)  + " "+ rset.getString(5)  + " "+ rset.getDouble(6)  + " "+ rset.getDouble(7)  + " "+ rset.getInt(8));
				empList.add(new EmpDTO(rset.getInt("empno"), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5), rset.getDouble(6), rset.getDouble(7), rset.getInt(8)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, pstmt, rset);
		}
		
		return empList;
		
	}
	
	
	/** 특정 직원 검색 **/
	public static EmpDTO selectOne(int empno) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		EmpDTO emp = null;
		
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement("select * from emp where empno=?");
			pstmt.setInt(1, empno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				//System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " + rset.getString(3) + " "+ rset.getInt(4)  + " "+ rset.getString(5)  + " "+ rset.getDouble(6)  + " "+ rset.getDouble(7)  + " "+ rset.getInt(8));
				emp = new EmpDTO(rset.getInt("empno"), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5), rset.getDouble(6), rset.getDouble(7), rset.getInt(8));
			}
						
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DButil.close(conn, pstmt, rset);
		}
		return emp;
	}

	/** 직원 정보 등록 **/
	/* insert into emp values (? ? ? ? ? ? ? ?) */
	public static boolean insertEmp(EmpDTO emps) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		
		conn = DButil.getConnection();		
		pstmt = conn.prepareStatement("insert into emp values (?, ?, ?, ?, ?, ?, ?, ?)");
		
		pstmt.setInt(1, emps.getEmpno());
		pstmt.setString(2, emps.getEname());
		pstmt.setString(3, emps.getJob());
		pstmt.setInt(4, emps.getMgr());
		pstmt.setString(5, emps.getHiredate());
		pstmt.setDouble(6, emps.getSal());
		pstmt.setDouble(7, emps.getComm());
		pstmt.setInt(8, emps.getDeptno());
		
		int i = pstmt.executeUpdate();
		
		if(i != 0) {
			return true;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DButil.close(conn, pstmt);
		}
		return false;
	}
	
	
	/** 특정 부서의 직원 연봉 정보 수정 **/
	/* update emp set sal = sal*? where deptno=? */
	public static boolean updateEmp(float c, int deptno) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		
		conn = DButil.getConnection();		
		pstmt = conn.prepareStatement("update emp set sal = sal*? where deptno=?");
		
		pstmt.setFloat(1, c);
		pstmt.setInt(2, deptno);

		int i = pstmt.executeUpdate();
		System.out.println(i);
		
		if(i > 0) {
			return true;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, pstmt);
		}
		return false;
	}
	
	
	/** 특정 직원 정보 삭제 **/
	/* delete from emp where empno=? */
	public static boolean deleteEmp(int empno) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		
		conn = DButil.getConnection();		
		pstmt = conn.prepareStatement("delete from emp where empno=?");
		
		pstmt.setDouble(1, empno);

		int i = pstmt.executeUpdate();
		
		if(i == 1) {
			return true;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, pstmt);
		}
		return false;
	}

}
