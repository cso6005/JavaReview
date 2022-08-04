/* package : step_util */
/* 자료구조 Set 학습 코드 */

/* import 할 클래스


/* 기록
* 1. 데이터 저장 : set.add()
* 2. 데이터 조회 : set은 index가 없기 때문에 get() 메소드를 제공하지 않는다.  
* 		=> 따라서 iterator(반복자)를 사용해야 한다. 이때, hasNext() & next() 함께 사용.
* 
* 3. hasNext() & next()
*  : lterator 인터페이스의 메서도로 자주 사용되며, lterator 에 추가적인 요소가 있을 때 가져오는 역할을 한다.
* 		- hasNext() : boolean 타입 반환 
* 		- next() : 매개변수 혹은 iterator 되는 타입 즉, 타입 따지지 않고 lterator에 입력된 값을 들고 오는 것.
* 4. 데이터 조회 구문에서 제네릭 문법 으로 타입 고정해줘야 형변환의 번거로움이 없다. 꼭 지정해주기
* 
* */

		 

package step01_util;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

public class SetT {
	
	@Test
	public void m1() {
		
		/* step1. set 에 값 대입 & set 메소드 사용 */
		HashSet<Integer> set = new HashSet<>();
		
		System.out.println(1 + " " + set.size());
		System.out.println(2 + " " + set.isEmpty()); // 비어있냐?
		
		set.add(1);
		set.add(1); // 기존 1 을 삭제하고! 저장하는 것!
		set.add(2);
		set.add(3);
		set.add(4);
		
		
		System.out.println(3 + " " + set.size());
		System.out.println(4 + " " + set.isEmpty()); // 데이터 존재 유무 boolean
		System.out.println(5 + " " + set.contains(3)); // 특정 데이터 존재 유무 찾는 메소드
		System.out.println(set); // set.toString() 


		/* step2. set 구조로 저장된 데이터를 하나씩 봅기위한 절차 : iterator 메소드 사용
		 * - 로직 -
		 * 데이터들을 열거 -> 열거된 데이터 존재 여부 확인 -> 데이터가 있으면 뽑아서 활용
		 * 데이터들을 열거 (Iterator)
		 * 		-> 열거된 데이터 존재 여부 확인(hasNext())
		 * 			-> 데이터가 있으면 뽑아서 활용(next()) 
		 * - 제네릭문법 타입 지정해주기
		 **/
		
		/* number 값을 가진 set 자료 구조의 값을 조회해보자.*/
		Iterator<Integer> no = set.iterator();
		while(no.hasNext()) {
			System.out.println(no.next());
		}
		
		

	
	
	
	}

}
