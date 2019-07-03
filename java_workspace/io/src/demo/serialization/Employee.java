package demo.serialization;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -2414995298900735231L;
	private String name;
	private String position;
	// 직렬화, 역직렬화대상에서 제외된다.
	private transient int password;
	private Family child;

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Family getChild() {
		return child;
	}

	public void setChild(Family child) {
		this.child = child;
	}
	
	
}
