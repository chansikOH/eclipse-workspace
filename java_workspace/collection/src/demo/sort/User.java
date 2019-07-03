package demo.sort;

public class User implements Comparable<User> {

	private int no;
	private String name;

	public User() {
		super();
	}

	public User(int no, String name) {
		super();
		this.no = no;
		this.name = name;
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

	@Override
	public int compareTo(User o) {
		return name.compareTo(o.name);
//		return no - o.no;
	}
	
	
}
