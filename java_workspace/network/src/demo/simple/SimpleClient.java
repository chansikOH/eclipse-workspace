package demo.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) throws Exception{
		
		// 서버에 연결요청
		Socket socket = new Socket("192.168.10.254", 8000);
		
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		
		PrintWriter writer = new PrintWriter(out);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		// 서버로 메세지 보내기
		writer.println("");
		writer.flush();
		
		// 서버가 보낸 메세지 읽기
		String message = reader.readLine();
		System.out.println("응답메세지 : " + message);
		
		socket.close();
	}
}
