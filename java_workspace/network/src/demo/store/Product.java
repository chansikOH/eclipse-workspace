package demo.store;

public class Product {

	int no;
	String name;
	String price;
	int stock;

	public Product() {
		super();
	}

	public Product(int no, String name, String price, int stock) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.stock = stock;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
