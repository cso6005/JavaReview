package view;

import java.util.ArrayList;

import controller.EmpController;
import model.EmpDAO;
import model.domain.EmpDTO;

public class EmpStartView {
	
	public static void main(String[] args) {
		
		System.out.println("*** 1. 모든 검색 ***");
		EmpController.emps();
		
		System.out.println("*** 2. 특정 직원 검색 ***");
		EmpController.emp(7369);
		EmpController.emp(1111);
		
		System.out.println("*** 3. 특정 직원 등록 ***");
		EmpController.insertEmp(new EmpDTO(7777, "CHARS", "CLERK", 7897, "1980-05-19", 850.00, 300.00, 20));
		EmpController.insertEmp(new EmpDTO(5555, "MINGI", "CLERK", 7369, "1989-08-19", 1050.00, 200.00, 30));
		
		System.out.println("*** 4. 특정 직원 연봉 정보 수정 ***");
		EmpController.updateEmp(1.5f, 10);
		
		System.out.println("*** 5. 특정 직원 정보 삭제 ***");
		EmpController.emp(7777);
		EmpController.deleteEmp(7777);
		EmpController.emp(7777);
		
		
	}

}
