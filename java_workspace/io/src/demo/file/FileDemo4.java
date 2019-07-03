package demo.file;

import java.io.File;

public class FileDemo4 {

	public static void main(String[] args) {
		
//		파일의 전체경로를 활용해서 파일객체를 초기화
		File file1 = new File("c:/temp/sample.txt");

//		디렉토리명과 파일명을 활용해서 파일객체 초기화
		File file2 = new File("c:/temp", "sample.txt");
		
//		디렉토리 정보를 가진 파일객체와 파일명을 확용해서 파일객체 초기화
		File dir = new File("c:/temp");
		File file3 = new File(dir, "sample.txt");
		
		
	}
}
