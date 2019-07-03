package day0322;

public class CartItem {

	private Product product;
	private Customer customer;
	private int amount;
	
	public CartItem() {
		super();
	}

	public CartItem(Product product, Customer customer, int amount) {
		super();
		this.product = product;
		this.customer = customer;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void displayInfo() {
		product.displayInfo();
		System.out.println("구매개수 : " + amount);
		System.out.println();
	}
	
}
