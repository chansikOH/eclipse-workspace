package day0322;

public class Product {

	private int no;
	private String name;
	private String category;
	private int price;
	private int stock;		// 상품재고		기본값: 1000
	private int likes;		// 상품판매지수	기본값: 0
	
	public Product() {
		super();
	}

	public Product(int no, String name, String category, int price) {
		super();
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = 1000;
		this.likes = 0;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public void displayInfo() {
		System.out.println("상품번호 : " + no);
		System.out.println("상품이름 : " + name);
		System.out.println("카테고리 : " + category);
		System.out.println("상품가격 : " + CommonUtils.numberWithComma(price) + "원");
		System.out.println("상품재고 : " + CommonUtils.numberWithComma(stock));
		System.out.println("판매지수 : " + likes);
		System.out.println();
	}
	
	
}
