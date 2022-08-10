/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  Donator.java
 * DESC  :  기부자 정보(Data)
 * 
 * @author  
 * @version 1.0
*/
package probono.model.dto;

public class Donator {
	/** 기부자 사번 */
	private int empno;
	
	/** 기부자 이름 */
	private String ename;
	
	/** 기부자 이메일 */
	private String email;
	
	/** 기부자 재능 */
	private String talent;

	public Donator() {}
	public Donator(int empno, String ename, String email, String talent) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.email = email;
		this.talent = talent;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTalent() {
		return talent;
	}

	public void setTalent(String talent) {
		this.talent = talent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("기부를 희망하는 사원번호 : ");
		builder.append(empno);
		builder.append(", 사원명 : ");
		builder.append(ename);
		builder.append(", 이메일 주소 : ");
		builder.append(email);
		builder.append(", 재능 : ");
		builder.append(talent);
		return builder.toString();
	}
}