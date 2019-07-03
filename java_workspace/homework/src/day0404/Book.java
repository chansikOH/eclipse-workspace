package day0404;

public class Book {

	private int no;
	private String title;
	private String publisher;
	private int price;
	private boolean isSell;
	
	public Book() {}

	public Book(int no, String title, String publisher, int price, boolean isSell) {
		super();
		this.no = no;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.isSell = isSell;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSell() {
		return isSell;
	}

	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}
	
	public void displayBook() {
		System.out.println("책 번 호 : " + no);
		System.out.println("책 제 목 : " + title);
		System.out.println("출 판 사 : " + publisher);
		System.out.println("책 가 격 : " + price);
		if (isSell = false) {
			System.out.println("판매여부 : 절판");
		} else {
			System.out.println("판매여부 : 판매중");
		}
	}
}
