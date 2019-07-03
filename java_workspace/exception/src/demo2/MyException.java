package demo2;

// 사용자정의 일반예외	<--	Exception 클래스를 상속받으면 일반예외가 된다.
//							일반예외는 예외처리가 필수다.
public class MyException extends Exception{

	public MyException() {
		
	}
	
	public MyException(String message) {
		super(message);	// 예외정보로 저장된다. (Exception의 생성자 호출)
	}
}
