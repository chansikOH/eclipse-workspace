package demo.bridge;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BridgeStreamDemo1 {

	public static void main(String[] args) throws Exception{
		
		System.out.print("이름을 입력하세요: ");
		
//		// 소스(키보드)와 연결된 InputStream
//		InputStream is = System.in;
//		// 바이트스트림을 문자스트림으로 변환해주는 InputStreamReader
//		InputStreamReader isr = new InputStreamReader(is);
//		// 다른 문자스트림과 연결해서 성능을 향상시키는 BufferedReader
//		BufferedReader br = new BufferedReader(isr);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		System.out.println(text);
		
	}
}
