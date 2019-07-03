package db.demo3;

import java.util.ArrayList;

public class UserService {
	UserDAO userDao = new UserDAO();

	public void updateUser(UserVO newUser) throws Exception {
		UserVO user = userDao.getUserById(newUser.getId());
		
		if(user == null) {
			throw new Exception("사용자 정보가 존재하지 않습니다.");
		}
		
		user.setName(newUser.getName());
		user.setPhone(newUser.getPhone());
		user.setEmail(newUser.getEmail());
		
		userDao.updateUser(user);
	}
	
	public void deleteUser(String id) throws Exception {
		UserVO user = userDao.getUserById(id);
		
		if (user == null) {
			throw new Exception("[" + id + "]에 해당하는 사용자정보를 찾을 수 없습니다.");
		}
		
		userDao.deleteUser(id);
	}
	
	public UserVO getUserById(String id) throws Exception {
		UserVO user = userDao.getUserById(id);
		
		if (user == null) {
			throw new Exception("[" + id + "]에 해당하는 사용자정보를 찾을 수 없습니다.");
		}
		
		return user;
	}
	
	public ArrayList<UserVO> searchUsersByName(String name) throws Exception {
		ArrayList<UserVO> users = userDao.searchUsersByName(name);
		
		if(users.isEmpty()) {
			throw new Exception("[" + name + "]에 해당하는 사용자정보를 찾을 수 없습니다.");
		}
		
		// 검색된 정보가 있을 경우에만 정보를 반환함.
		return users;
	}
	
	public ArrayList<UserVO> getAllUsers() throws Exception {
		ArrayList<UserVO> users = userDao.getAllUsers();
		
		return users;
	}
	
	public void addNewUser(UserVO user) throws Exception {
				
		// 사용자가 입력한 아이디로 사용자정보를 조회한다.
		UserVO dbUser = userDao.getUserById(user.getId());
		
		// 이미 등록된 사용자정보가 존재하는지 체크한다.
		if (dbUser != null) {
			throw new Exception("동일한 아이디를 가진 사용자가 이미 존재합니다.");
		}
		
		// 등록된 사용자정보가 없으면 신규 사용자로 등록한다.
		userDao.addUser(user);
	}
	
}
