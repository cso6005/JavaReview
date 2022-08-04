/* 예외처리 학습 01 내용
 * - 예외 종류 
 * - try catch 기본 구문
 * */


/* 예외 클래스 필수 암기 사항
 * - 문제가 발생이 된다 하더라도 종료가 아니라 유연한 실행 유지 
 * 1. 다수의 예외 상황을 예외 클래스명으로 이미 다수 제공
 * 2. 향후엔 직접 개발도 가능
 * 3. 구조
 * 
 * 1) runtime 예외 체험 및 처리
 * 
 * 2) compile 예외 체험 및 처리
 * 		java.lang.RuntimeException 과 무관한 모든 예외 클래스 즉 complie 예외는
 * 		 => 무조건~!~! try-catch 필수
 * 
 * 
 * 4. 발생된 예외에 대한 보고해주는 메소드
		e.printStackTrace();
 * */

package step02.exception;


class A{
	static {
		System.out.println("A.class가 실행을 위해 메모리에 로딩될 때 자동 실행되는 블록");
	}
}

public class ExceptionT1 {

	public static void main(String[] args) {
		
		/* step02 - compile 예외 체험 및 처리 => try-catch */ 
		
		/* 자바의 컴파일 예외 처리 예시 - byte code 를 메모리에 로딩하는 API 를 통해 자바의 컴파일 예외처리 에 대해 알아보자.
		 * java.lang.Class
		 * public static Class forName(String filename){
		 * 		fileName의 byte code 를 메모리 로딩
		 * }
		 * 
		 * 1. 경우의 수 1 : 존재하는 byte code 명을 parameter 했을 경우
		 * 	- 정상 로딩
		 * 
		 * 2. 경우의 수 2 : 미존재하는 byte code 명을 parameter 했을 경우
		 * 	- 비정상 로딩
		 * 	- 호출한 곳으로 비정상 실행을 알려줘야 함.
		 * 	- classNotFoundException
		 * */
		
		
		// 컴파일 예외 처리 해주는 구문
		try {
			System.out.println(1);
			
			//없는 클래스 호출. => 예외 발생
			// 예외 발생 줄에서 바로 catch 구문으로 간다.
			Class.forName("step04.exception.3443");
			System.out.println(2); // 윗 줄 예외로 실행되지 않는 줄

		} catch (ClassNotFoundException e) {
			System.out.println(3);
			
			// 발생된 예외에 대한 보고해주는 메소드
			e.printStackTrace();
		}
		System.out.println(4);


		
		/* step01 - runtime 예외 체험 및 처리 */
		
		/* 예시1) java.lang.NullPointerException */
			// s = null 로 초기화 후 s.length() 실행 시 NullPointerException 발생
			// 해결책 s 라는 변수에 값 대입으로 문제 해결
			// 실행 시에 발생한 예외는 코드 수정으로 해결 완료		
		String s = null;
		//System.out.println(s.length());
		
		/* 예시 2) java.lang.ArrayIndexOutOfBoundsException */
			// 없는 인덱스의 값을 불렀기에
		int [] i = {1,2};
		//System.out.println(i[5]);

	}

}
