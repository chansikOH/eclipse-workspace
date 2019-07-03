package demo2;

public class Contact implements Cloneable{
	
	private int no;
	private String name;
	private String tel;
	private String email;
	
	public Contact() {
		
	}

	public Contact(int no, String name, String tel, String email) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [no=" + no + ", name=" + name + ", tel=" + tel + ", email=" + email + "]";
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

//	Object의 toString() 메소드 재정의
	
	/*
	 * public String toString() { String text = null;
	 * 
	 * text = "번호:" + no + " 이름:" + name + " 연락처:" + tel + " 이메일:" + email;
	 * 
	 * return text; }
	 */
	
	public Contact copyContact() throws CloneNotSupportedException {
		Object obj = clone();
		Contact c = (Contact)obj;
		return c;
	}
}
