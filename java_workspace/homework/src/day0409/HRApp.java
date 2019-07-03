package day0409;

import java.util.Scanner;

public class HRApp {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		HRService service = new HRService();
		
		while (true) {
			System.out.println("1.사원검색 2.연도검색 3.급여등급검색 4.부서검색 5.관리자검색 0.종료");
			
			System.out.print("메뉴선택> ");
			int selNo = sc.nextInt();
			
			if (selNo == 1) {
				System.out.print("사원아이디 입력> ");
				int employeeID = sc.nextInt();
				
				service.searchByEmployeeID(employeeID);
				
			} else if (selNo == 2) {
				System.out.print("연도 입력> ");
				int year = sc.nextInt();
				
				service.searchByYear(year);
				
			} else if (selNo == 3) {
				System.out.print("급여등급 입력> ");
				String jobGrade = sc.next();
				
				service.searchByJobGrade(jobGrade);
			
			} else if (selNo == 4) {
				System.out.print("부서아이디 입력> ");
				int departmentID = sc.nextInt();
				
				service.searchByDepartmentID(departmentID);
				
			} else if (selNo == 5) {
				System.out.print("관리자이름 입력> ");
				String managerName = sc.next();
				
				service.searchByManagerName(managerName);
			
			} else if (selNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		sc.close();
	}
}
