/* package : step_util */
/* 자료구조 Map 학습 코드 */

/* contents 설계 */

/* import 할 클래스
 * model.domain.Department
 * model.domain.Employee/

/* 기록
 * 1) 부서 변경을 적용하는 것이니 당연히 출력 메소드 매개변수에 dept 를 넣어야 함. getDept() 를 넣지 않게 주의
 * 		- ex) empInfoPoint1(getEmps(dept));
 * 2) map 자료 구조를 for 문을 이용해 값을 하나씩 보고 싶을 땐  keySet() 메소드 이용. // 또 다른 방법이 있긴 함.
 * 		- ex) for (Integer key: emps.keySet())
 * */

package step01_util;

import java.util.HashMap;

import org.junit.Test;

import model.domain.Department;
import model.domain.Employee;

public class MapT {
	

	static HashMap<Integer, Department> getDept(){
		HashMap<Integer, Department> dept = new HashMap<>();
		
		dept.put(1, new Department(10, "IT", "마포"));
		dept.put(2, new Department(20, "DS", "이천"));
		dept.put(3, new Department(30, "CS", "판교"));
		dept.put(4, new Department(40, "DX", "서초"));
	
		return dept;
	}
	
	static HashMap<Integer, Employee> getEmps(HashMap<Integer, Department> dept){
		HashMap<Integer, Employee> emps = new HashMap<>();
		
		emps.put(1, new Employee(1, "김민지", 900.5, dept.get(4)));
		emps.put(2, new Employee(2, "이철수", 400.3, dept.get(1)));
		emps.put(3, new Employee(3, "신민철", 500.5, dept.get(3)));
		emps.put(4, new Employee(4, "최민기", 1000.5, dept.get(2)));
		emps.put(5, new Employee(5, "최민기", 1100.5, dept.get(1)));
		
		return emps;

	
	}
	
	/* 직원 정보 조회 메소드 */
	static void empInfoPoint1(HashMap<Integer, Employee> emps) {
		
		for (Integer key: emps.keySet()) {
			System.out.println(emps.get(key));
		}	
	}
	

	
	/* 직원 정보 조회 메소드 - 이름, 부서명 조회 */
	static void empInfoPoint2(HashMap<Integer, Employee> emps) {
		
		for (Integer key: emps.keySet()) {
			System.out.println("사원명:" + emps.get(key).getEname() + " "
					+ "부서명:" + emps.get(key).getDept().getDname());
		}
			
			

						
	}
	
	/* 부서 지역 변경 메소드 */
	static void setDepartmentloc (HashMap<Integer, Department> dept, String loc, int deptno) {
		
		for (Integer key :dept.keySet()) {
			if (dept.get(key).getDeptno() == deptno) {
				dept.get(key).setLoc(loc);
				empInfoPoint1(getEmps(dept));
				
			}
		
		}

	}
	
	
	public static void main(String[] args) {
		System.out.println("**전직원 정보 - 전체 정보 조회**");
		empInfoPoint1(getEmps(getDept()));
		System.out.println();
		
		System.out.println("**전직원 정보 - 이름, 부서명 조회**");
		empInfoPoint2(getEmps(getDept()));
		System.out.println();
		
		System.out.println("**특정 부서 지역 변경 후 전 직원 정보**");
		setDepartmentloc(getDept(), "청주", 20);

		
		
	}
	

}

