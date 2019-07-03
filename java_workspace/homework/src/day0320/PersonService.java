package day0320;
/*
 * 1. 학생, 교수, 직원 정보의 등록 기능을 지원한다.
 * 2. 학생별, 교수별, 직원별 검색 기능을 지원한다.
 * 3. 전체(학생+교수+직원) 인원을 대상으로 검색 기능을 지원한다. 
 */

import java.util.ArrayList;

public class PersonService {

	private ArrayList<Person> people = new ArrayList<Person>();

	
//	교수, 학생, 직원 등록기능을 제공하는 메소드
	public void addPerson(Person person) {
		people.add(person);
	}
	
//	Role타입을 전달받아서 Role타입에 해당되는 정보를 출력하는 메소드
//	role값은 "S", "P", "E" 중에 하나다.
//	"S"면 저장된 정보중에서 학생정보(번호, 이름, 학과, 학년, 재학여부, 생성일) 전부를,
//	"P"면 저장된 정보중에서 교수정보(번호, 이름, 학과, 직위, 연구과제, 생성일) 전부를,
//	"E"면 저장된 정보중에서 직원정보(번호, 이름, 부서, 직위, 급여, 생성일) 전부를 출력한다.
	public void printPerson(String role) {
//		Enhanced-for문, getRole(), 타입형변환 등이 사용되어야 함
		if (!role.equals("S") && !role.equals("P") && !role.equals("E")) {
			throw new HTAException("일치하는 직군이 존재하지 않습니다.");
		}
		for(Person person : people) {
			if (person.getRole().equals(role)) {
				person.displayInfo();
			} 
		}
	}
	
//	이름을 전달받아서 그 이름에 해당하는 정보를 출력하는 메소드
//	* 교수, 학생, 직원 전체에서 그 이름에 해당하는 정보를 검색해서 출력해야 함.
//	* 검색된 사람의 Role을 확인해서 그 사람의 모든 정보를 출력해야함.
	public void printPersonByName(String name) {
//		Enhanced-for문, getRole(), 타입형변환 등이 사용되어야 함
		boolean check = false;
		for (Person person : people) {
			if (person.getName().equals(name)) {
				check = true;
				person.displayInfo();
			}
		}
		if (!check) {
			throw new HTAException("일치하는 이름이 존재하지 않습니다.");
		}
	}

}
