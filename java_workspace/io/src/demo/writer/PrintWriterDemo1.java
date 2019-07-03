package demo.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterDemo1 {

	public static void main(String[] args) throws Exception{
		
//		PrintWriter writer = new PrintWriter("c:/temp/scores.csv");		권장
		
//		File file = new File("c:/temp/scores.csv");
//		PrintWriter writer = new PrintWriter(file);
		
		PrintWriter writer = new PrintWriter(new FileWriter("c:/temp/scores.csv"));
		
//		writer.write("김유신,전자공학과,3,3.8\n");
		writer.println("김유신,전자공학과,3,3.8");
		writer.println("이순신,기계공학과,4,4.1");
		writer.println("강감찬,무기재료공학과,1,4.5");
		writer.println("홍길동,환경공학과,2,3.2");
		
		writer.flush();
		
		writer.close();
	}
}
