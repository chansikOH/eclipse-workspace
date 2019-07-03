package demo1;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo2 {

	public static void main(String[] args) throws IOException {
		// 예외처리 위임하기
		FileWriter writer = new FileWriter("sample.txt");
		writer.write("연습");
		writer.flush();
		writer.close();
	}
}
