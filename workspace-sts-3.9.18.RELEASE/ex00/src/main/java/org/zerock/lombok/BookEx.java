package org.zerock.lombok;

public class BookEx {

	public static void main(String[] args) {
		Book book = new Book("ȫ�浿", "����");
		
		System.out.println("å���� : " + book.getTitle());
		System.out.println("��  �� : " + book.getTitle());
		System.out.println(book);
		
		

	}

}
