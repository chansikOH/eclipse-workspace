package demo2;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo1 {

	public static void main(String[] args) {
//		예외정보 얻기, 출력하기
		try {
			FileWriter writer = new FileWriter("c:/sample.txt");
			writer.write("예외정보 얻기");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("예외발생!!!");
			
			String message = e.getMessage();
			System.out.println("예외정보 : " + message);
			
			String text = e.toString();
			System.out.println("예외정보 : " + text);
			
			e.printStackTrace();
		}
	}
}
