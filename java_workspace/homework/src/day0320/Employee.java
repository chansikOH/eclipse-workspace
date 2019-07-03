package day0320;

import java.util.Date;

/*
 * 1. Person 추상클래스를 상속받는다.
 * 2. 근무부서, 직위, 급여를 저장하는 필드를 정의한다.
 * 3. 기본 생성자를 정의한다.
 * 4. 번호, 이름, 근무부서, 직위, 급여(salary), 생성일을 전달받아서 초기화하는 생성자를 정의한다.
 * 		(번호, 이름, 생성일의 초기화는 부모의 생성자를 활용한다.)
 * 5. 근무부서, 직위, 급여 필드의 getter/setter 메소드를 정의한다.
 * 6. Person으로부터 물려받은 추상메소드(String getRole())를 구현(재정의)한다.
 * 		(교수클래스는 "E" 값을 반환한다.)
 */
public class Employee extends Person{

	private String dept;
	private String position;
	private int salary;
	
	public Employee () {
		
	}

	public Employee(int no, String name, String dept, String position, int salary, Date createDate) {
		super(no, name, createDate);
		this.dept = dept;
		this.position = position;
		this.salary = salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getRole() {
		return "E";
	}
	
	public void displayInfo() {
		System.out.println("번    호: " + getNo());
		System.out.println("이    름: " + getName());
		System.out.println("부    서: " + dept);
		System.out.println("직    위: " + position);
		System.out.println("급    여: " + CommonUtils.numberWithComma(salary));
		System.out.println("생 성 일: " + CommonUtils.dateToString(getCreateDate()));
	}
}
