package kr.co.hta.member.vo;

public class Car {

	private String name;
	private Maker company;
	private int price;
	private int year;
	
	public Car() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Maker getCompany() {
		return company;
	}

	public void setCompany(Maker company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
