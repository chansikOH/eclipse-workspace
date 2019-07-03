package day0412;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesApp {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		
		EmployeesService employeesService = new EmployeesService();
		
		String loginId = null;
		
		while(true) {
			try {
				System.out.println("1.로그인 2.학과등록 3.교수등록 4.학생등록  "
						+ "5.학생 재학상태 변경 6.교수정보조회 7.학생정보조회 0.종료");
				
				System.out.print("메뉴선택> ");
				int selectNo = scanner.nextInt();
				
				if (selectNo == 1) {
					System.out.println("[로그인]");
					
					System.out.print("아이디 입력> ");
					String id = scanner.next();
					System.out.print("비밀번호 입력> ");
					String password = scanner.next();
					
					boolean isSuccess = employeesService.login(id, password);
					
					if(isSuccess) {
						loginId = id;
						System.out.println("[" + loginId + "님 환영합니다]");
					}
					
				} else if (selectNo == 2) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");	
					}
					
					System.out.println("[학과등록]");
					
					System.out.print("등록할 학과명 입력> ");
					String deptName = scanner.next();
					
					employeesService.addDepartment(deptName);
					
				} else if (selectNo == 3) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					
					System.out.println("[교수 등록]");
					
					System.out.print("아 이 디 입력> ");
					String id = scanner.next();
					System.out.print("이    름 입력> ");
					String name = scanner.next();
					System.out.print("비밀번호 입력> ");
					String password = scanner.next();
					System.out.print("직    위 입력> ");
					String position = scanner.next();
					System.out.print("학과번호 입력> ");
					int deptNo = scanner.nextInt();
					
					ProfessorVO professor = new ProfessorVO();
					professor.setId(id);
					professor.setName(name);
					professor.setPassword(password);
					professor.setPosition(position);
					professor.setDeptNo(deptNo);
					
					employeesService.addProfessor(professor);
										
				} else if (selectNo == 4) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					
					System.out.println("[학생 등록]");
					
					System.out.print("아 이 디 입력> ");
					String id = scanner.next();
					System.out.print("이    름 입력> ");
					String name = scanner.next();	
					System.out.print("비밀번호 입력> ");
					String password = scanner.next();
					System.out.print("학    년 입력> ");
					int grade = scanner.nextInt();
					System.out.print("재학상태 입력> ");
					String status = scanner.next();
					System.out.print("학과번호 입력> ");
					int deptNo = scanner.nextInt();
					
					if (!status.equals("재학중")) {
						throw new Exception("입력 값이 잘못되었습니다.");
					}
					
					StudentVO student = new StudentVO();
					student.setId(id);
					student.setName(name);
					student.setPassword(password);
					student.setGrade(grade);
					student.setStatus(status);
					student.setDeptNo(deptNo);
					
					employeesService.addStudent(student);
					
				} else if (selectNo == 5) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[학생 재학상태 변경]");
					
					System.out.println("재학상태 변경중인 학생목록");
					
					boolean isSuccess = false;
					ArrayList<StudentVO> stud = employeesService.searchAllStud();
					for (StudentVO stu : stud) {
						if (stu.getReqStatus()!= null && stu.getReqStatus().equals("N")) {
							System.out.println("아 이 디 : " + stu.getId());
							System.out.println("이    름 : " + stu.getName());
							System.out.println("학    년 : " + stu.getGrade());
							System.out.println("재학상태 : " + stu.getStatus());
							System.out.println("등 록 일 : " + stu.getCreateDate());
							System.out.println("재학상태 변경완료 여부 : \n" + stu.getReqStatus());
							System.out.println("소속학과 : " + stu.getDeptName());
							System.out.println();
							
							isSuccess = true;
						} 	
					}
					
					if (!isSuccess) {
						System.out.println("변경할 학생이 없습니다.");
					} else {
						System.out.print("변경완료할 학생 아이디 입력> ");
						String id = scanner.next();
						
						employeesService.updateStudReqStatus(id);
					}
									
				} else if (selectNo == 6) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[전체 교수 조회]");
					
					ArrayList<ProfessorVO> prof = employeesService.searchAllProf();
					for (ProfessorVO pro : prof) {
						System.out.println("아 이 디 : " + pro.getId());
						System.out.println("이    름 : " + pro.getName());
						System.out.println("직    위 : " + pro.getPosition());
						System.out.println("입 사 일 : " + pro.getHireDate());
						System.out.println("근무여부 : " + pro.getWorking());
						System.out.println("등 록 일 : " + pro.getCreateDate());
						System.out.println("소속학과 : " + pro.getDeptName());
						System.out.println();
					}
					
				} else if (selectNo == 7) {
					if(loginId == null) {
						throw new Exception("[로그인 후에 이용하세요]");						
					}
					System.out.println("[전체 학생 조회]");
					
					ArrayList<StudentVO> stud = employeesService.searchAllStud();
					for (StudentVO stu : stud) {
						System.out.println("아 이 디 : " + stu.getId());
						System.out.println("이    름 : " + stu.getName());
						System.out.println("학    년 : " + stu.getGrade());
						System.out.println("재학상태 : " + stu.getStatus());
						System.out.println("등 록 일 : " + stu.getCreateDate());
						System.out.println("소속학과 : " + stu.getDeptName());
						System.out.println();
					}
					
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
