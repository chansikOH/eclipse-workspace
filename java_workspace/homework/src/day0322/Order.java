package day0322;

import java.util.ArrayList;
import java.util.Date;

public class Order {

	private Customer customer;
	private ArrayList<Goods> goodsItems = new ArrayList<Goods>();
	private Date createDate;
	
	public Order() {
		super();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Goods> getGoodsItems() {
		return goodsItems;
	}

	public void setGoodsItems(ArrayList<Goods> goodsItems) {
		this.goodsItems = goodsItems;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public void displayInfo() {
		customer.displayInfo();
		for(Goods goods : goodsItems) {
			goods.displayInfo();
		}
		System.out.println("구매날짜 : " + CommonUtils.dateToString(createDate));
	}
	
}
