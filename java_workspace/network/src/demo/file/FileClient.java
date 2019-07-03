package demo.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class FileClient {

	public static void main(String[] args) throws Exception {
		
		// 소켓을 생성해서 서버에 연결요청하기
		Socket socket = new Socket("192.168.10.254", 8000);
		
		// 소켓으로부터 입력스트림/출력스트림 획득하기
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		
		// 소켓으로부터 획득한 스트림을 보조스트림과 연결하기
		DataOutputStream dos = new DataOutputStream(out);
		DataInputStream dis = new DataInputStream(in);
		
		File file = new File("c:/temp/nako.jpg");
		
		String filename = file.getName();					// 파일이름 획득
		long filesize = file.length();						// 파일사이즈 획득
		FileInputStream fis = new FileInputStream(file);	// 파일데이터 획득을 위한 입력스트림 생성
		
		// 서버로 파일명, 파일사이즈, 파일데이터 보내기
		dos.writeUTF(filename);
		dos.writeLong(filesize);
		IOUtils.copy(fis, dos);	// FileInputStream으로 읽어서 DataOutputStream 으로 복사
		
		// 서버로부터 메세지 수신하기
		String message = dis.readUTF();
		System.out.println("응답메세지 : " + message);
		
		socket.close();
	}
}
