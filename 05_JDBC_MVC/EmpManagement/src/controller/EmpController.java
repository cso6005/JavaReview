package controller;

import java.util.ArrayList;

import model.EmpDAO;
import model.domain.EmpDTO;
import view.EmpFailview;
import view.EmpSuccessView;

public class EmpController {

	/** 모든 직원 정보 요청 및 응답 메소드 **/
	public static void emps() {
		try {
			ArrayList<EmpDTO> emps = EmpDAO.selectAll();
			if (emps.size() != 0) {
				EmpSuccessView.printEmps(emps);
			} else {
				EmpSuccessView.printMsg("검색되 직원이 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			EmpFailview.printMsg("모든 직원 검색을 다시 시도해주세요!");
		}

	}

	/** 직원 한 명의 정보 요청 및 응답 메소드 **/
	public static void emp(int empno) {
		if (empno != 0) {
			try {
				EmpDTO emp = EmpDAO.selectOne(empno);
				if (emp != null) {
					EmpSuccessView.printEmp(emp);
				} else {
					EmpSuccessView.printMsg("직원번호 " + empno + " 번 직원이 없습니다.");
				}

			} catch (Exception e) {
				e.printStackTrace();
				EmpFailview.printMsg("모든 직원 검색을 다시 시도해주세요!");
			}
		} else {
			EmpSuccessView.printMsg("직원번호 " + empno + " 번 직원이 없습니다.");
		}

	}

	/** 직원 정보 등록 요청 메소드 **/
	public static void insertEmp(EmpDTO emps) {
		try {
			boolean b = EmpDAO.insertEmp(emps);
			if (b) {
				EmpSuccessView.printMsg("직원 정보가 등록되었습니다.");
			} else {
				EmpFailview.printMsg("직원 등록을 다시 시도해주세요!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			EmpFailview.printMsg("직원 등록을 다시 시도해주세요!");
		}
	}

	/** 직원 정보 수정 메소드 **/
	public static void updateEmp(float c, int deptno) {
		try {
			boolean b = EmpDAO.updateEmp(c, deptno);
			if (b) {
				EmpSuccessView.printMsg("직원 정보가 수정되었습니다.");
				EmpSuccessView.printMsg(deptno + "번 부서의 인상률이 " + c + "로 연봉 정보 수정 되었습니다.");
			} else {
				EmpFailview.printMsg("직원 정보 수정을 다시 시도해주세요!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			EmpFailview.printMsg("직원 정보 수정을 다시 시도해주세요!");
		}

	}

	/** 직원 정보 삭제 메소드 **/
	public static void deleteEmp(int empno) {
		try {
			boolean b = EmpDAO.deleteEmp(empno);
			if (b) {
				EmpSuccessView.printMsg("직원 정보가 삭제되었습니다.");
			} else {
				EmpFailview.printMsg("직원 정보 삭제을 다시 시도해주세요!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			EmpFailview.printMsg("직원 정보 삭제을 다시 시도해주세요!");
		}

	}



}
