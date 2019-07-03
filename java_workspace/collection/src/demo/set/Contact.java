package demo.set;

public class Contact {

	private int no;
	private String name;
	private String tel;
	
	
	public Contact() {
		super();
	}


	public Contact(int no, String name, String tel) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
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


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (no != other.no)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Contact [no=" + no + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
}
