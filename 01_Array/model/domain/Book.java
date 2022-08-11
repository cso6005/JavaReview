/* Book 정보 - 책이름, 카테고리 */


package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Book {
	
	// 이름
	private String name;	
	// 카테고리 
	private String category; 

	

}

