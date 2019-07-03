package demo2;

// 사용자 정의 실행예외	<--	RuntimeException을 상속받으면 실행예외가 된다.
//							실행예외는 예외처리가 선택이다.
public class MyRuntimeException extends RuntimeException{

	public MyRuntimeException() {
		
	}
	
	public MyRuntimeException(String message) {
		super(message);
	}
}
