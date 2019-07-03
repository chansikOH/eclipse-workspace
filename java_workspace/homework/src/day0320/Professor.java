package day0320;

import java.util.Date;

/*
 * 1. Person 추상클래스를 상속받는다.
 * 2. 소속학과, 직위, 연구과제명을 저장하는 필드를 정의한다.
 * 3. 기본 생성자를 정의한다.
 * 4. 번호, 이름, 소속학과, 직위(position), 연구과제명(research), 생성일을 전달받아서 초기화하는 생성자를 정의한다.
 * 		(번호, 이름, 생성일의 초기화는 부모의 생성자를 활용한다.)
 * 5. 소속학과, 직위, 연구과제명 필드의 getter/setter 메소드를 정의한다.
 * 6. Person으로부터 물려받은 추상메소드(String getRole())를 구현(재정의)한다.
 * 		(교수클래스는 "P" 값을 반환한다.)
 */
public class Professor extends Person{

	private String dept;
	private String position;
	private String research;
	
	public Professor() {
		
	}

	public Professor(int no, String name, String dept, String position, String research, Date createDate) {
		super(no, name, createDate);
		this.dept = dept;
		this.position = position;
		this.research = research;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getReserch() {
		return research;
	}

	public void setReserch(String reserch) {
		this.research = reserch;
	}
	
	public String getRole() {
		return "P";
	}
	
	public void displayInfo() {
		System.out.println("번    호: " + getNo());
		System.out.println("이    름: " + getName());
		System.out.println("학    과: " + dept);
		System.out.println("직    위: " + position);
		System.out.println("연구과제: " + research);
		System.out.println("생 성 일: " + CommonUtils.dateToString(getCreateDate()));
	}
}
