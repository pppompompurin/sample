package org.zerock.lombok;

public class BookEx {

	public static void main(String[] args) {
		Book book = new Book("홍길동", "허준");
		
		System.out.println("책제목 : " + book.getTitle());
		System.out.println("저  자 : " + book.getTitle());
		System.out.println(book);
		
		

	}

}
