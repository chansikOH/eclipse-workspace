package demo.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	// 서버에 접속한 모든 클라이언트와 통신을 담당하는 스레드(ChatServerThread)를 저장하는 ArrayList객체 생성하기
	private ArrayList<ChatServerThread> threadList = new ArrayList<ChatServerThread>();
	
	public ChatServer() {
		
		try {
			ServerSocket server = new ServerSocket(8000);
			System.out.println("채팅 서버가 시작됨 ... ");
			
			while(true) {
				try {
					System.out.println("클라이언트의 요청 대기중 ...");
					// 연결요청을 수락하고, 
					// 연결요청을 한 클라이언트와 통신하는 소켓 획득하기
					Socket socket = server.accept();
					System.out.println("클라이언트의 연결 완료 ...");
					
					// 송수신을 담당하느 스레드 만들기
					ChatServerThread thread = new ChatServerThread();
					threadList.add(thread);
					thread.setSocket(socket);
					thread.setThreadList(threadList);
					thread.start();
					
				} catch (Exception e) {
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
	
}
