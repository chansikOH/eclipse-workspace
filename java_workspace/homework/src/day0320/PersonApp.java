package day0320;

import java.util.Date;
import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		PersonService service = new PersonService();
		
		while (true) {
			System.out.println("1.교수등록 2.직원등록 3.학생등록 4.이름으로 찾기 5.직군별 출력 0.종료");
			
			System.out.print("메뉴 선택> ");
			int selNo = sc.nextInt();
			
			if(selNo == 1) {
				System.out.println("[교수 등록]");
				
				System.out.print("번호입력> ");
				int no = sc.nextInt();
				System.out.print("이름입력> ");
				String name = sc.next();
				System.out.print("학과입력> ");
				String dept = sc.next();
				System.out.print("직위입력> ");
				String position = sc.next();
				System.out.print("연구과제입력> ");
				String research = sc.next();
				
				Date createDate = new Date();
				Person person = new Professor(no, name, dept, position, research, createDate);
				service.addPerson(person);				
			} else if (selNo == 2) {
				System.out.println("[직원 등록]");
				
				System.out.print("번호입력> ");
				int no = sc.nextInt();
				System.out.print("이름입력> ");
				String name = sc.next();
				System.out.print("부서입력> ");
				String dept = sc.next();
				System.out.print("직위입력> ");
				String position = sc.next();
				System.out.print("급여입력> ");
				int salary = sc.nextInt();
				
				Date createDate = new Date();
				Person person = new Employee(no, name, dept, position, salary, createDate);
				service.addPerson(person);
			} else if (selNo == 3) {
				System.out.println("[학생 등록]");
				
				System.out.print("번호입력> ");
				int no = sc.nextInt();
				System.out.print("이름입력> ");
				String name = sc.next();
				System.out.print("학과입력> ");
				String dept = sc.next();
				System.out.print("학년입력> ");
				int grade = sc.nextInt();
				System.out.print("재학여부입력(재학 or 휴학)> ");
				String isEnroll = sc.next();
				boolean enroll = false;
				if (isEnroll.equals("재학")) {
					enroll = true;
				} else if (isEnroll.equals("휴학")) {
					enroll = false;
				} else {
					throw new HTAException("입력이 잘못되었습니다.");
				}
						
				Date createDate = new Date();
				Person person = new Student(no, name, dept, grade, enroll, createDate);
				service.addPerson(person);
			} else if (selNo == 4) {
//				이름을 입력받아서 이름으로 검색기능 실행
				System.out.print("이름입력> ");
				String name = sc.next();
				
				service.printPersonByName(name);
			} else if (selNo == 5) {
//				직군("P", "S", "E")을 입력받아서 직군별 출력기능 실행
				System.out.println("직군입력");
				System.out.print("교수(P) or 학생(S) or 직원(E)> ");
				String role = sc.next();
				
				service.printPerson(role);
			} else if (selNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println();
		}
		
		sc.close();
	}
}
