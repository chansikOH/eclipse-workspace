package demo.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatClient extends JFrame {

	private JTextArea messageTextArea = new JTextArea();
	private JTextArea inputTextArea = new JTextArea();
	private JButton sendButton = new JButton("전송");
	
	public ChatClient() {
		
		try {
			Socket socket = new Socket("192.168.10.254", 8000);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 수신전용 작업을 실행하는 스레드 생성
			ChatClientThread cct = new ChatClientThread();
			// 서버가 전송한 메세지를 수신하는 스트림 전달
			cct.setIn(in);
			// 메세지를 표현할 컨트롤 전달
			cct.setMessageTextArea(messageTextArea);
			// 스레드를 실행가능 상태로 만듦
			cct.start();
			
			setTitle("심플 채팅");
			setLayout(new BorderLayout());
			
			messageTextArea.setEditable(false);
			
			JPanel bottomPanel = new JPanel(new BorderLayout());
			
			JScrollPane scrollPane = new JScrollPane(inputTextArea);
			inputTextArea.setPreferredSize(new Dimension(0, 50));
			bottomPanel.add(scrollPane, BorderLayout.CENTER);
			bottomPanel.add(sendButton, BorderLayout.EAST);
			
			add(new JScrollPane(messageTextArea), BorderLayout.CENTER);
			add(bottomPanel, BorderLayout.SOUTH);
			
			
			setVisible(true);
			setBounds(200, 200, 500, 700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			sendButton.addActionListener(e->{
				// 입력된 텍스트를 읽어오기
				String text = inputTextArea.getText();
				// 서버로 텍스트 보내기
				out.println(text);
				out.flush();
				
				// 입력창의 텍스트 지우기
				inputTextArea.setText("");
			});
			
			inputTextArea.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					// 입력창에 입력된 텍스트를 읽어온다.
					String text = inputTextArea.getText();
					// 텍스트의 길이가 1이상이면 전송버튼 활성화
					// 입력된 텍스트가 없으면 전송버튼 비활성화
					if (text.length() > 0) {
						sendButton.setEnabled(true);
					} else {
						sendButton.setEnabled(false);
					}
				}
			});
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "서버와 통신중 오류가 발생하였습니다", "통신 오류", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}
	
}