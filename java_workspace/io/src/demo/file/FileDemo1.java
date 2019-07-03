package demo.file;

import java.io.File;
import java.util.Date;

public class FileDemo1 {

	public static void main(String[] args) {
		
//		지정된 파일의 정보를 가지는 파일 객체 생성하기
		File file = new File("c:/java_workspace/oop6/Account.java");
		
//		String getName()
//		파일명 획득하기
		String filename = file.getName();
		System.out.println("파일명 : " + filename);
		
//		long length()
//		파일 사이즈 획득하기
		long filesize = file.length();
		System.out.println("파일사이즈 : " + filesize + "바이트");
		
//		String getPath()
//		전체경로 획득하기
		String path = file.getPath();
		System.out.println("전체 경로: " + path);
		
//		String getParent()
//		파일이 위치한 디렉토리 경로 획득하기
		String directoryPath = file.getParent();
		System.out.println("디렉토리 경로 : " + directoryPath);
		
//		boolean isFile()
//		파일인지 여부를 반환한다. 파일인 경우 true를 반환. (디렉토리는 파일이 아님)
		boolean isFile = file.isFile();
		System.out.println("파일인가? " + isFile);
		
//		boolean isDirectory()
//		디렉토리인지 여부를 반환한다. 디렉토리인 경우 true를 반환
		boolean isDirectory = file.isDirectory();
		System.out.println("디렉토리인가? " + isDirectory);
		
//		boolean exists()
//		존재하는지 여부를 반환한다.
		boolean exists = file.exists();
		System.out.println("존재하는가? " + exists);
		
//		long lastModified()
//		파일의 최종수정일자를 유닉스시간으로 반환한다.
		long time = file.lastModified();
		System.out.println("최종수정일자 : " + time);
		Date date = new Date(time);
		System.out.println("최종수정일자 : " + date);
	}
}
