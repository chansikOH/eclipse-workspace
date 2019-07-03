package day0412;

import java.util.Scanner;

public class ProfessorApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ProfessorService professorService = new ProfessorService();
		
		String loginId = null;
		
		while (true) {
			try {
				System.out.println("1.로그인 2.모든개설과정 3.소속학과 개설과정 4.개설현황 5.개설과정등록 "
						+ "6.수강중인 학생조회 7.성적입력 0.종료");
				
				System.out.print("메뉴선택> ");
				int selectNo = scanner.nextInt();
				
				if(selectNo == 1) {
					System.out.println("[로그인]");
					
					System.out.print("아이디 입력> ");
					String id = scanner.next();
					System.out.print("비밀번호 입력> ");
					String password = scanner.next();
					
					boolean isSuccess = professorService.login(id, password);
					
					if(isSuccess) {
						loginId = id;
						System.out.println("[" + loginId + "님 환영합니다]");
					}
				} else if (selectNo == 2) {
				
				} else if (selectNo == 3) {
				
				} else if (selectNo == 4) {
				
				} else if (selectNo == 5) {
				
				} else if (selectNo == 6) {
				
				} else if (selectNo == 7) {
				
				} else if (selectNo == 0) {
					System.out.println("프로그램 종료");
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		scanner.close();
	}
}
