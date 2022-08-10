package project;

import org.junit.Test;

import model.domain.Book;

public class ArraysBook {
	
	@Test
	public void BookArray() {
		
	/* 0. Book 정보 - 책이름, 카테고리 */
		Book [] b = {new Book("a", "소설"),
					new Book("b", "역사"),
					new Book("c", "에세이"),
					new Book("d", "소설"),
					new Book("e", "IT"),
					new Book("f", "IT")};
	
		
	/* 1. 객체 정보 조회 */
	// 1) Book 배열 객체 조회
	System.out.println("**Book 배열 객체 조회**");
	System.out.println(b);
	
	// 2) Book 객체 0 ~ 5 번 조회 
	System.out.println("**Book 객체 0 ~ 5 번 조회**");
	for(Book v : b) {
		System.out.println(b[0]);	
	}
	
	/* 2. 책 정보 전체 조회 */
	System.out.println("**책 조회**");
	for(Book v: b) {
		System.out.println(" 책:" + v.getName() + " 카데고리:" + v.getCategory());
	}	
	
	
	/* 3. 특정 카테고리 책 정보 조회*/
	// 1) 소설 책 조회 
	System.out.println("**소설 책 조회**");
	for(Book v: b) {
		if(v.getCategory() == "소설") {
		System.out.println(" 책:" + v.getName() + " 카데고리:" + v.getCategory());
		}
	}
	
	// 2) IT 책 조회 
	System.out.println("**IT 책 조회**");
	for(Book v: b) {
		if(v.getCategory() == "IT") {
		System.out.println(" 책:" + v.getName() + " 카데고리:" + v.getCategory());
		}
	}
	
	
	
	}


}
