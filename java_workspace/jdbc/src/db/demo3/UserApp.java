package db.demo3;

import java.util.ArrayList;
import java.util.Scanner;

public class UserApp {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		UserService service = new UserService();
		
		try {
			while (true) {
				System.out.println("1.가입 2.전체조회 3.이름검색 4.아이디검색 5.삭제 6.정보변경 0.종료");
				
				System.out.print("메뉴선택> ");
				int selectNo = sc.nextInt();
				
				if(selectNo == 1) {
					System.out.println("[회원 가입]");
					
					System.out.print("아이디 입력> ");
					String id = sc.next();
					System.out.print("이름 입력> ");
					String name = sc.next();
					System.out.print("비밀번호 입력> ");
					String pwd = sc.next();
					System.out.print("전화번호 입력> ");
					String phone = sc.next();
					System.out.print("이메일 입력> ");
					String email = sc.next();
					
					UserVO user = new UserVO();
					user.setId(id);
					user.setName(name);
					user.setPwd(pwd);
					user.setPhone(phone);
					user.setEmail(email);
					
					service.addNewUser(user);
				} else if (selectNo == 2) {
					System.out.println("[전체 조회]");
					
					ArrayList<UserVO> users = service.getAllUsers();
					if(users.isEmpty()) {
						System.out.println("조회된 사용자 정보가 없습니다.");
					}
					for (UserVO user : users) {
						System.out.println("아 이 디 : " + user.getId());
						System.out.println("이    름 : " + user.getName());
						System.out.println("전화번호 : " + user.getPhone());
						System.out.println("이 메 일 : " + user.getEmail());
						System.out.println("포 인 트 : " + user.getPoint());
						System.out.println("생 성 일 : " + user.getCreateDate());
						System.out.println();
					}
					
				} else if (selectNo == 3) {
					System.out.println("[이름 검색]");
					
					System.out.print("이름 입력> ");
					String name = sc.next();
					
					ArrayList<UserVO> users = service.searchUsersByName(name);
					
					for (UserVO user : users) {
						System.out.println("아 이 디 : " + user.getId());
						System.out.println("이    름 : " + user.getName());
						System.out.println("전화번호 : " + user.getPhone());
						System.out.println("이 메 일 : " + user.getEmail());
						System.out.println("포 인 트 : " + user.getPoint());
						System.out.println("생 성 일 : " + user.getCreateDate());
						System.out.println();
					}
				
				} else if (selectNo == 4) {
					System.out.println("[아이디 검색]");
					
					System.out.print("아이디 입력> ");
					String id = sc.next();
					
					UserVO user = service.getUserById(id);
					
					System.out.println("아 이 디 : " + user.getId());
					System.out.println("이    름 : " + user.getName());
					System.out.println("전화번호 : " + user.getPhone());
					System.out.println("이 메 일 : " + user.getEmail());
					System.out.println("포 인 트 : " + user.getPoint());
					System.out.println("생 성 일 : " + user.getCreateDate());
					System.out.println();

				} else if (selectNo == 5) {
					System.out.println("[삭제]");
					
					System.out.print("삭제할 아이디 입력> ");
					String id = sc.next();
					
					service.deleteUser(id);
				} else if (selectNo == 6) {
					System.out.println("[정보변경]");
					
					System.out.print("변경대상 아이디 입력> ");
					String id = sc.next();
					System.out.print("새 이름 입력> ");
					String name = sc.next();
					System.out.print("새 연락처 입력> ");
					String phone = sc.next();
					System.out.print("새 이메일 입력> ");
					String email = sc.next();
					
					UserVO newUser = new UserVO();
					newUser.setId(id);
					newUser.setName(name);
					newUser.setPhone(phone);
					newUser.setEmail(email);
					
					service.updateUser(newUser);
				} else if (selectNo == 0) {
					System.out.println("프로그램 종료");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		sc.close();
	}
}
