package day0320;

import java.util.Date;

public abstract class Person {

	private int no;
	private String name;
	private Date createDate;
	
	public Person() {
		
	}
	
	public Person(int no, String name, Date createDate) {
		super();
		this.no = no;
		this.name = name;
		this.createDate = createDate;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public abstract String getRole();	// 역할을 제공하는 메소드
	public abstract void displayInfo();
}
