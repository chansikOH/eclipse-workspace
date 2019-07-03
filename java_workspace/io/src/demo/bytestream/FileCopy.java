package demo.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();
		
		// 지정된 파일을 읽어오는 FileInputStream 생성하기
		FileInputStream in = new FileInputStream("c:/temp/tomcat.exe");
		
		// 지정된 파일명을 기록하는 FileOutputStream 생성하기
		FileOutputStream out = new FileOutputStream("c:/temp/copy_tomcat.exe");
		
		// 배열에 저장되는 데이터의 객수를 저장하는 변수
		int len = 0;
		// InputStream으로 읽어들인 데이터를 저장하는 배열
		byte[] buf = new byte[1024*8];
		// int read(byte[] buf)는 InputStream으로 읽어들인 데이터를
		// 전달받은 배열에 저장하고, 최종적으로 저장된 개수를 반환한다.
		while ((len = in.read(buf)) != -1) {
			// void write(byte[] buf, int offset, int len)은 전달받은 배열에 저장된 데이터를 
			// offset 위치부터 len 갯수만큼 기록한다.
			out.write(buf, 0, len);
		}
		
		in.close();
		out.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (endTime - startTime) + " 밀리초");
	}
}
