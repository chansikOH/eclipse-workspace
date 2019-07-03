package day0314;

import java.util.Scanner;

public class ScoreApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ScoreService service = new ScoreService();
		
		for (;;) {
			System.out.println("1.입력 2.전체출력 3.이름으로 출력 4.평균으로 출력 5.성으로 출력 0.종료");
			System.out.print("메뉴 선택> ");
			int selNo = sc.nextInt();
			
			if (selNo == 1) {
				/*
				 * 1. 학번,이름,국어,영어,수학 점수를 입력받는다. <-- "1,홍길동,80,70,90"
				 * 2. 입력받은 값을 배열로 변경한다.
				 * 3. 배열의 값을 꺼내서 숫자정보는 각각 정수로 변환한다.
				 * 4. Score 객체를 생성하고, 값을 저장한다.
				 * 5. ScoreService의 addScore 메소드를 실행한다.
				 */
				System.out.println("[학생정보 입력]");
				System.out.print("학번,이름,국어,영어,수학 입력> ");
				String text = sc.next();
				
				String[] items = text.split(",");
				int no = Integer.parseInt(items[0]);
				int kor = Integer.parseInt(items[2]);
				int eng = Integer.parseInt(items[3]);
				int math = Integer.parseInt(items[4]);
				
				Score s = new Score();
				s.setNo(no);
				s.setName(items[1]);
				s.setKor(kor);
				s.setEng(eng);
				s.setMath(math);
				
				service.addScore(s);
				
			} else if (selNo == 2) {
				System.out.println("[전체 학생정보 출력]");
				
				service.printAllScores();
				
			} else if (selNo == 3) {
				System.out.println("[학생 정보 조회]");
				System.out.print("학생이름 입력> ");
				String name = sc.next();
				
				service.printScoreByName(name);
				
			} else if (selNo == 4) {
				System.out.println("[평균으로 출력]");
				System.out.print("점수 입력> ");
				int s = sc.nextInt();
				
				service.printScoreByAverage(s);
			} else if (selNo == 5) {
				System.out.println("[성씨로 출력]");
				System.out.print("성씨 입력> ");
				String lastname = sc.next();
				
				service.printScoreByLastname(lastname);
			} else if (selNo == 0) {
				System.out.println("시스템 종료");
				break;
			}
			System.out.println();
		}
		sc.close();
	}
}
