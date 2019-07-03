package demo.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class FileServer {

	public static void main(String[] args) throws Exception {
		
		// 클라이언트의 연결 요청을 처리할 ServerSocket 생성
		ServerSocket server = new ServerSocket(8000);
		System.out.println("서버가 시작되었습니다.");
		while (true) {
			// 클라이언트의 연결요청이 접수되면 그 클라이언트와 통신할 소켓을 제공받는다.
			Socket socket = server.accept();
			
			// 소켓으로부터 입력스트림/출력스트림 획득
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// 위에서 획득한 문자열, 정수, 파일데이터를 송수신할 수 있는 
			// 보조스트림(DataInputStream, DataOutputStream)과 연결
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			
			// 클라이언트가 보낸 문자열, 정수 읽어오기
			String filename = System.currentTimeMillis() + dis.readUTF();
			long filesize = dis.readLong();
			
			// 클라이언트가 보낸 파일을 저장할 스트림 생성하기
			FileOutputStream fos = new FileOutputStream("c:/temp/" + filename);
			System.out.println("["+filename+"] 저장을 시작");
			
			// 클라이언트가 보낸 파일데이터 읽어서 파일로 저장하기
			int readSize = 0;						// 읽어온 파일 데이터의 크기를 저장할 변수
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len=dis.read(buf)) != -1) {		// 1. 스트림으로부터 데이터 읽기
				fos.write(buf, 0, len);				// 2. 파일에 기록하기
				readSize += len;					// 3. 읽어들인 파일 데이터 크기를 증가시키
				if (readSize == filesize) {			// 4. 읽어들인 파일의 크기와 파일사이즈가 일치하면 
					break;							// 		반복 탈출하기
				}
			}
			fos.close();
			System.out.println("["+filename+"] 저장이 완료");
			
			// 클라이언트에 응답 메세지 보내기
			dos.writeUTF("["+filename+"]의 저장이 완료되었습니다.");
			dos.flush();			
		}
	}
}
