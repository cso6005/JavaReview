/* package : step_util */

/* wrapper class & autoboxing & unboxing 학습 코드 */

/* 기록
 * 1. wrapper class
 * - 기본 타입을 support 하는 8가지 '클래스'
 * - java.lang 제공
 * 
 * - 기본 타입     래퍼 클래스
 * 	- byte		Byte
 * 	- short		Short
 * 	- int		Integer
 * 	- long		Long
 * 	- float		Float
 * 	- double	Double
 * 	- char		Character
 * 	- boolean	Boolean
 * 
 * 2. 데이터 타입 두가지
 * 		1. 기본 타입 - class 없이 값만 표현
 * 		2. 참조 타입 - class 기반으로 생성 따라서 class 보유한 변수, 메소드 호출 가능 
 * 
 * 3. autoboxing & unboxing
 *  	- unboxing : Wrapper 클래스 타입을 원시 타입으로 변환하는 과정의 의미
 *  		ex) Integer -> int
 *  	- autoboxing : 원시 타입의 값을 해당하는 wrapper 클래스의 객체로 바꾸는 과정을 의미
 *  		ex) int -> Integer
 *  
 * */

package step01_util;

import org.junit.Test;

public class WrapperT {
	
	@Test
	public void m1() {

		// 기본타입변수에 참조타입값 대입 또는 참조타입변수에 기본타입값 대입은 불가능. 그런데 왜 실행될까?
		
		// 1. unboxing : 컴파일시점에 기본값화 한다.	
		//  int i = (new Integer(3)).intValue(); - int 로 자동 변환
		int i = new Integer(3); //int로 자동변환하여 int 변수 i 에 대입.
		System.out.println(i); //int값이 출력된다!
		
		//오류. i가 int로 unboxing 되었으므로, class 즉 참조타입이 아니여서 메소드 호출 불가
		//System.out.println(i.toString()); 
		
		
		// 2. autoboxing : 컴파일 시점에서 객체화 한다.
		// Integer i2 = new Integer(3) - 객체로 자동 변환
		Integer i2 = 5; // 객체로 자동변환하여 Integer 참조타입 변수 i2 에 대입.
		System.out.println(i2);
		System.out.println(i2.toString());
		
	}
	

}
