package demo1;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo3 {

	public static void method1() throws IOException {
	FileWriter writer = new FileWriter("sample.txt");
	writer.write("예외 떠넘기기");
	writer.flush();
	writer.close();
	}
	
	public static void method2() throws ClassNotFoundException{
		Class.forName("demo1.ExceptionDemo1");	// demo1.ExceptionDemo1 설계도를 메모리에 로딩시킨다.
	}
	
	// method1()과 method2()가 처리를 위임한 예외를 다시 떠넘긴다.
	public static void method3() throws IOException, ClassNotFoundException {
		ExceptionDemo3.method1();
		ExceptionDemo3.method2();
	}
	
	// method1()과 method2()가 처리를 위임한 예외를 try ~ catch로 처리한다.
	public static void method4() {
		try {
			ExceptionDemo3.method1();
			ExceptionDemo3.method2();
		} catch (IOException e)	{
			
		} catch (ClassNotFoundException e) {
			
		}

	}
	
	public static void method5() {
		try {
			ExceptionDemo3.method1();
			ExceptionDemo3.method2();
		} catch (IOException | ClassNotFoundException e)	{
			
		}

	}
	
	public static void method6() {
		try {
			ExceptionDemo3.method1();
			ExceptionDemo3.method2();
		} catch (Exception e)	{		// Exception 타입의 변수로 선언하면 
										// try 블록에서 발생되는 모든 예외를 캐치할 수 있다.
		}
	}
	
	public static void method7() {
		try {
			ExceptionDemo3.method1();
			ExceptionDemo3.method2();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		} catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		
	}
}
