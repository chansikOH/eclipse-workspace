package demo1;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo4 {

	public static void method1() throws HTAException {	// throws 예외 떠넘기기
		try {
			FileWriter writer = new FileWriter("sample.txt");
			writer.write("예외 바꾸기");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new HTAException();					// throw 예외 발생시키기
		}
	}
	
	public static void method2() throws HTAException{	// 3. 2번에서 발생시킨 예외를 떠넘긴다.
		try {
			Class.forName("demo1.HTAException");
		} catch (ClassNotFoundException e) {			// 1. try 블록에서 발생한 예외를 개치한다.
			throw new HTAException();					// 2. HTAException예외를 생성해서 발생시킨다.
		}
	}
	
	public static void main(String[] args) {
		try {
			method1();
			method2();			
		} catch (HTAException e) {		// 4. 처리를 위임받은 예외의 종류가 
										//    HTAException으로 줄어들게 된다.
		}
	}
}
