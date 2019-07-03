package day0412;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsApp {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		StudentsService studentsService = new StudentsService();
		CourseService courseService = new CourseService();
		
		String loginId = null;
		
		while(true) {
			try {
				System.out.println("1.로그인 2.모든개설과정 3.소속학과 개설과정 4.수강신청현황 5.수강신청 "
						+ "6.수강신청 취소 7.재학상태 변경요청 0.종료");
				
				System.out.print("메뉴선택> ");
				int selectNo = scanner.nextInt();
				
				if(selectNo == 1) {
					System.out.println("[로그인]");
					
					System.out.print("아이디 입력> ");
					String id = scanner.next();
					System.out.print("비밀번호 입력> ");
					String password = scanner.next();
					
					boolean isSuccess = studentsService.login(id, password);
					
					if(isSuccess) {
						loginId = id;
						System.out.println("[" + loginId + "님 환영합니다]");
					}
					
				} else if (selectNo == 2) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[모든 개설과정 조회]");
					
					ArrayList<CourseVO> cour = courseService.searchAllcourses();
					for (CourseVO cou : cour) {
						System.out.println("과정번호 : " + cou.getNo());
						System.out.println("담당교수 : " + cou.getProfId());
						System.out.println("과정학과 : " + cou.getDeptName());
						System.out.println("과정이름 : " + cou.getName());
						System.out.println("등 록 일 : " + cou.getCreateDate());
						System.out.println("모집정원 : " + cou.getQuota());
						System.out.println();
					}
									
				} else if (selectNo == 3) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[소속학과 개설과정 조회]");
					
					ArrayList<CourseVO> cour = studentsService.searchCourseByDept(loginId);
					for(CourseVO cou : cour) {
						System.out.println("과정번호 : " + cou.getNo());
						System.out.println("담당교수 : " + cou.getProfId());
						System.out.println("과정학과 : " + cou.getDeptName());
						System.out.println("과정이름 : " + cou.getName());
						System.out.println("등 록 일 : " + cou.getCreateDate());
						System.out.println("모집정원 : " + cou.getQuota());
						System.out.println();
					}
				
				} else if (selectNo == 4) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[수강신청 현황]");
					
					ArrayList<CourseRequestListVO> courReq = studentsService.searchCourseReq(loginId);
					for (CourseRequestListVO couRe : courReq) {
						System.out.println("신청번호 : " + couRe.getReqNo());
						System.out.println("과정번호 : " + couRe.getCourseNo());
						System.out.println("과정이름 : " + couRe.getCourseName());
						System.out.println("신 청 일 : " + couRe.getCreateDate());
						System.out.println("성    적 : " + couRe.getCourseScore());
						System.out.println();
					}
				
				} else if (selectNo == 5) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[수강 신청]");
					
					System.out.print("개설과정 번호 입력> ");
					int courseNo = scanner.nextInt();
					
					studentsService.requestCourse(courseNo, loginId);
				
				} else if (selectNo == 6) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[수강신청 취소]");
					
					System.out.print("개설과정 번호 입력> ");
					int courseNo = scanner.nextInt();
					
					studentsService.deleteCourseReq(courseNo, loginId);
				
				} else if (selectNo == 7) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[재학상태 변경요청]");
					
					System.out.print("재학상태(재학중, 휴학중, 자퇴) 입력> ");
					String status = scanner.next();
					
					if(!status.equals("재학중") && !status.equals("휴학중") && !status.equals("자퇴")) {
						throw new Exception("입력이 잘못되었습니다.");
					}
					
					studentsService.updateStatus(status, loginId);
				
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
