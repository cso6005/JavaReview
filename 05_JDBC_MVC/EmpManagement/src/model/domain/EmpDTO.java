/*
 * +----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| empno    | int          | NO   | PRI | NULL    |       |
| ename    | varchar(20)  | YES  |     | NULL    |       |
| job      | varchar(20)  | YES  |     | NULL    |       |
| mgr      | smallint     | YES  |     | NULL    |       |
| hiredate | date         | YES  |     | NULL    |       |
| sal      | decimal(7,2) | YES  |     | NULL    |       |
| comm     | decimal(7,2) | YES  |     | NULL    |       |
| deptno   | int          | YES  | MUL | NULL    |       |
+----------+--------------+------+-----+---------+-------+
*/

package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	//private Date hiredate;
	private String hiredate; // String 으로 하는 게 보편적. 더편하다.
	private double sal;
	private double comm;
	private int deptno;


}
