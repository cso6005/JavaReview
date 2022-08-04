/* 예외처리 학습 03 - throws 구문 */

/* 활용 예제 - 사용자 정의 예외를 발생시키기 */
/* Q. admin 이 아닌 자가 login 시도 시, 즉 예외 발생했을 때 로그 기록 - info 레벨 로 처리 */
	// admin 이 아니면 예외 발생 하고 예외 발생시 log기록
	// admin 이 아니면(조건) 예외 발생(개발자가 코드로 생성해서 던짐) 하고 예외 발생시 log기록

/* 다음에 할 것 - 계정 정보 클래스 만들어서 직접 관리자 인지 아닌지 찾는 로직 짜보기*/

package step02.exception;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import model.domain.Department;

public class ExceptionT3 {
	
	
	static Logger logger = Logger.getLogger("ExceptionTest3");
	

	static void loginCheck(String id) throws Exception {
		if( !id.equals("amdin") ) { //admin이 아닌 경우 true  (!false) -> true

			throw new Exception("로그인을 시도한 무효한 id : " + id);
		}
		System.out.println("관리자 접속");
	}
	
	public static void main(String[] args) {
		try {
			loginCheck("amdin");
			loginCheck("test");
		} catch (Exception e) {
			e.printStackTrace();
			
			//예외 객체가 보유하고 있는 문자열 데이터 출력
//			System.out.println(e.getMessage());
			// throw 에서도 가능하지만, catch 문장에서 log 기록 처리를 해주는 것이 좋다.
			logger.info(e.getMessage());
		}
	}

}
