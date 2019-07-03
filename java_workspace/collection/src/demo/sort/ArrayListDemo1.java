package demo.sort;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(10, "김유신"));
		users.add(new User(80, "이순신"));
		users.add(new User(40, "류관순"));
		users.add(new User(50, "홍길동"));
		users.add(new User(20, "강감찬"));
		
		Collections.sort(users);
		
		for (User user : users) {
			System.out.println(user.getNo() + "," + user.getName());
		}
	}
}
