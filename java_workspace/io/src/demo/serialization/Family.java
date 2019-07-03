package demo.serialization;

import java.io.Serializable;

public class Family implements Serializable{

	private String name;
	private int count;

	
	public Family() {
		super();
	}

	public Family(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
}
