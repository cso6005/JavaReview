package view;

import java.util.ArrayList;

import model.domain.EmpDTO;

public class EmpSuccessView {
	
	public static void printEmps(ArrayList<EmpDTO> emps) {
		for(EmpDTO e : emps) {
			System.out.println(e);
		}
	}
	
	public static void printEmp(EmpDTO emp) {
		System.out.println(emp);
	}
	
	public static void printMsg(String msg) {
		System.out.println(msg);
	}

}
