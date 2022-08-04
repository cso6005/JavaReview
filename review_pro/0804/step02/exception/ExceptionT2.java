/* 예외처리 학습 02 - throws 구문 */

package step02.exception;

public class ExceptionT2 {

	// 예외 발생시 throws 로 예외 처리 위임. 
	// 예외 발생 시 할 처리를 해당 구문에 적어주는 것.
	static void m1() throws ClassNotFoundException {
		Class.forName("step04.exception.A212");
	}
	public static void main(String[] args) {
		try {
			m1(); // throws 호출
			
		// ClassNotFoundException e 객체 받아서 처리.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

/*  개발자 도우미 메소드 : e.printStackTrace()
 * 	java.lang.ClassNotFoundException: step04.exception.A212
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:636)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:182)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:519)
	at java.base/java.lang.Class.forName0(Native Method)
	at java.base/java.lang.Class.forName(Class.java:375)
	
	at step04.exception.ExceptionTest2.m1(ExceptionTest2.java:8)
	at step04.exception.ExceptionTest2.main(ExceptionTest2.java:12)
 * 
 * */
