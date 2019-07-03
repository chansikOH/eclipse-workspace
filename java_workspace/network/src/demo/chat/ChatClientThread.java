package demo.chat;

import java.io.BufferedReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

// 메세지 수신 전용 스레드
public class ChatClientThread extends Thread{

	private BufferedReader in;
	private JTextArea messageTextArea;
	
	
	@Override
	public void run() {
		while (true) {
			try {
				// 서버로부터 메세지 수신
				String text = in.readLine();
				
				// 메세지를 채팅창에 표현
				messageTextArea.append(text + "\n");
				messageTextArea.setCaretPosition(messageTextArea.getText().length());
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "서버와 연결이 끊어졌습니다.", "연결 오류", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			// 수신 기능
			
			// 메세지 표현 기능
			
		}
	}
	public void setIn(BufferedReader in) {
		this.in = in;
	}
	public void setMessageTextArea(JTextArea messageTextArea) {
		this.messageTextArea = messageTextArea;
	}
	
	
}
