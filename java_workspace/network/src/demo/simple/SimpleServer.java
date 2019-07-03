package demo.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8000);
		System.out.println("서버가 시작되었습니다...");
		
		while (true) {
			// Socket accept()
			// 1. 클라이언트의 연결요청이 있을 때까지 프로그램 실행을 일시정지시킨다.
			// 2. 클라이언트의 연결요청이 접수되면 그 클라이언트와 통신할 때 사용할 Socket객체를 제공한다.
			Socket socket = server.accept();
			
			// Socket객체가 제공하는 입력스트림과 출력스트림 획득하기
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// Socket으로부터 획득한 스트림을 
			// 문자열 전송이 가능하도록 적절한 보조스트림과 연결시키기
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			PrintWriter writer = new PrintWriter(out);
			
			String name = reader.readLine();
			System.out.println("["+name+"]이 접속하였습니다.");
			
			writer.println(name + "님 환영합니다.");
			writer.flush();
			
		}
	}
}
