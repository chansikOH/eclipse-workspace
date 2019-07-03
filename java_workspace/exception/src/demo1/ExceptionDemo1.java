package demo1;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		// 일반예외가 발생하는 경우 예외처리하기
		try {
			System.out.println("try 블록의 수행문 시작");
			FileWriter writer = new FileWriter("sample.txt");
			writer.write("연습");
			writer.flush();
			writer.close();
			System.out.println("try 블록의 수행문 종료");
		} catch (IOException e) {
			System.out.println("파일 생성 혹은 파일 기록중 오류가 발생하였습니다.");
			System.out.println(e);
			System.out.println("catch 블록의 수행문");
		} finally {
			System.out.println("finally 블록의 수행문");
		}
		
	}
}
