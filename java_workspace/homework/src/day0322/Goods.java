package day0322;

import java.util.Date;

public class Goods {

	private Product product;
	private int amount;
	private Date createDate;
	
	public Goods() {
		super();
	}

	public Goods(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
		this.createDate = new Date();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
	
	public int totalPrice() {
		return product.getPrice()*amount;
	}
	
	public void displayInfo() {
		product.displayInfo();
		System.out.println("구매개수 : " + amount);
		System.out.println("단    가 : " + CommonUtils.numberWithComma(product.getPrice()) + "원");
		System.out.println("생 성 일 : " + CommonUtils.dateToString(createDate));
		System.out.println("총구매가 : " + CommonUtils.numberWithComma(totalPrice()));
		System.out.println();
	}
}
