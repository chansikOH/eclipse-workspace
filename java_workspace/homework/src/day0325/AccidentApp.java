package day0325;

import java.util.Scanner;

public class AccidentApp {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		AccidentService service = new AccidentService();
		
		// 파일정보 로드
		service.load();
		
		while (true) {
			System.out.println("1.지역별 조회 2.총발생건수 조회 3.총 사망자수 조회 4.총 사상자수 조회 0.종료");
			
			System.out.print("메뉴선택> ");
			int selNo = scanner.nextInt();
			
			if(selNo == 1) {
				// 지역명을 입력받는다.
				System.out.println("[지역별 조회]");
				
				System.out.print("지역명 입력> ");
				String locationName = scanner.next();
				
				service.printAccidentInfo(locationName);
			} else if (selNo == 2) {
				System.out.println("[총 발생건수 조회]");
				
				service.printTotalAccidentCount();
			} else if (selNo == 3) {
				System.out.println("[총 사망자수 조회]");
				
				service.printTotalDeaths();
			} else if (selNo == 4) {
				System.out.println("[총 사상자수 조회]");
				
				service.printTotalBoth();
			} else if (selNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		scanner.close();
	}
}
