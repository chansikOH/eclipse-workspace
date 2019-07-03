package day0321;

public class Book {

	private String title;
	private String category;
	private String writer;
	private String publisher;
	private int price;
	
	public Book() {
		super();
	}
	
	public Book(String title, String category, String writer, String publisher, int price) {
		super();
		this.title = title;
		this.category = category;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	public void displayInfo() {
		System.out.println("제    목 : " + title);
		System.out.println("카테고리 : " + category);
		System.out.println("작    가 : " + writer);
		System.out.println("출 판 사 : " + publisher);
		System.out.println("가    격 : " + CommonUtils.numberWithComma(price) + "원");
		System.out.println();
	}
}
