package day0325;

public class Accident {

	private String location;	// 발생지역 5
	private int count;			// 발생건수 6
	private int both;			// 사상자수 7
	private int death;			// 사망자수 8

	
	public Accident() {
		super();
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getBoth() {
		return both;
	}


	public void setBoth(int both) {
		this.both = both;
	}


	public int getDeath() {
		return death;
	}


	public void setDeath(int death) {
		this.death = death;
	}
	
	
	
}
