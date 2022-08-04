/* 
 * 1. main.domian
 * public class Employee 
 * 
 * 2. 실행 
 * public class ArrayListWrapperTest
 * */

package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Department {
	
	private int deptno; // 부서 번호
	private String dname; // 부서명
	private String loc; // 부서 위치(지역)
	

}
