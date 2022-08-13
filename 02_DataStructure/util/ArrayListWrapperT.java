/* package : step_util */
/* 자료구조 ArrayList 학습 코드 */
/* contents 설계 */

/* import 할 클래스
 * model.domain.Department
 * model.domain.Employee/

/* 기록
 * 1) ArrayList 생성 시 제네릭 문법을 이용해 값의 타입을 각 참조 타입으로 고정해준다.
 * 		형 변환의 번거로움을 피할 수 있다. 
 * 2) 부서 변경을 적용하는 것이니 당연히 출력 메소드 매개변수에 dept 를 넣어야 함. getDept() 를 넣지 않게 주의

 * */

package step01_util;

import java.util.ArrayList;

import model.domain.Department;
import model.domain.Employee;

public class ArrayListWrapperT {
	
	
	// 부서 정보 ArrayList
	static ArrayList<Department> getDept(){
		ArrayList<Department> dept = new ArrayList();
		
		dept.add(new Department(100, "IT", "서초"));
		dept.add(new Department(200, "DS", "용인"));
		dept.add(new Department(300, "CS", "판교"));	
		
		return dept;
	}
	
	// 직원 정보 ArrayList
	static ArrayList<Employee> getEmps(ArrayList<Department> dept){
	
		ArrayList<Employee> emps = new ArrayList<>();
				
		emps.add(new Employee(1, "김민지", 900.5, dept.get(0)));
		emps.add(new Employee(2, "이철수", 1000.10, dept.get(1)));
		emps.add(new Employee(3, "신민철", 600, dept.get(1)));
		emps.add(new Employee(4, "유혜진", 1000, dept.get(2)));
		emps.add(new Employee(5, "최민기", 400, dept.get(2)));
		
		return emps;
	}

	// 직원 정보 조회 메소드1 - 전체 정보 조회 (emps 자체 출력)
	static void empInfoPrint(ArrayList<Employee> emps) {
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		}
	
	// 직원 정보 조회 메소드2 - 이름, 부서명 조회 
	static void empInfoPrint2(ArrayList<Employee> emps) {
		for(Employee emp : emps) {
			System.out.println("사원명:" + emp.getEname() + " 부서명:" + emp.getDept().getDname());			
		}
		}
	
	// sal 1000 이상 직원 정보 조회 메소드
	static void empSal(ArrayList<Employee> emps) {
		for(Employee emp : emps) {
			if (emp.getSal() > 1000) {
				System.out.println(emp);
			}	
			}
	}

	// 특정 부서 정보 조회 메소드
	static void empDept(ArrayList<Employee> emps, String d) {
		for(Employee emp : emps) {
			if (emp.getDept().getDname() == d) {
				System.out.println(emp);
				}	
				}
	}
	
	// 부서 지역 변경 메소드 1
	static void setDepartmentloc(ArrayList<Department> dept, String loc) {
		dept.get(0).setLoc(loc);
		empInfoPrint(getEmps(dept));	
	
}

	// 부서 지역 변경 메소드 2 - 변경할 부서 번호 받아서 처리
	static void setDepartmentloc2(ArrayList<Department> dept, int Deptno, String loc) {
		for (Department d : dept) {
			if (d.getDeptno() == Deptno) {
				d.setLoc(loc);
				empInfoPrint(getEmps(dept));
			}
		}
				
		}

	
	public static void main(String[] args) {
		System.out.println("**전직원 정보**");
		empInfoPrint(getEmps(getDept()));
		System.out.println();
		
		System.out.println("**sal 1000 이상  직원 정보**");
		empSal(getEmps(getDept()));
		System.out.println();

		System.out.println("**특정 부서 정보 - IT**");
		empDept(getEmps(getDept()), "IT");
		System.out.println();
		
		System.out.println("**특정 부서 정보 - DS**");
		empDept(getEmps(getDept()), "DS");
		System.out.println();
		
		System.out.println("**특정 부서 지역 변경 후 전 직원 정보**");
		setDepartmentloc2(getDept(), 100, "구로");


		
		
	}

}





