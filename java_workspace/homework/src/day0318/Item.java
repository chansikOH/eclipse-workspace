package day0318;

import java.util.Date;

public class Item {

	private Product product;	// 상품(장바구니, 구매)
	private User user;			// 사용자
	private int amount;			// 수량(장바구니, 구매)
	private Date createDate;	

	
	public Item() {}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getTotalPrice() {
		return this.product.getPrice()*this.amount;
	}
	
}
