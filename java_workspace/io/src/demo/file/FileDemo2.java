package demo.file;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {

	public static void main(String[] args) throws IOException {
		
		File file = new File("c:/temp/sample.txt");
		
//		새 파일 생성하기
		file.createNewFile();
	}
}
