package day0322;

public class Customer {

	private String id;
	private String password;
	private String name;
	private int point;

	public Customer() {
		super();
	}

	public Customer(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public void displayInfo() {
		System.out.println("아 이 디 : " + id);
		System.out.println("이    름 : " + name);
		System.out.println("포 인 트 : " + point);
		System.out.println();
	}
}
