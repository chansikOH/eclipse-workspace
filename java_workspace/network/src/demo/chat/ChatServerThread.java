package demo.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerThread extends Thread{

	private ArrayList<ChatServerThread> threadList;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public void sendMessage(String message) throws Exception{
		out.println(message);
		out.flush();
	}
	
	public void broadcastMessage(String message) throws Exception{
		for (ChatServerThread thread : threadList) {
			thread.sendMessage(message);
		}
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				// 클라이언트가 보낸 메세지 수신하기
				String message = in.readLine();
				
				// 수신된 메세지를 모든 클라이언트에게 보내기
				broadcastMessage(message);
				
			}
		} catch(Exception e) {
			
		}
	}

	public void setThreadList(ArrayList<ChatServerThread> threadList) {
		this.threadList = threadList;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}
