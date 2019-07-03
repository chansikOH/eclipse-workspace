package demo.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo1 {

	public static void main(String[] args) throws Exception{
		
		FileInputStream fis = new FileInputStream("c:/temp/emp.sav");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// Object readObject()
		// 스트림으로 읽어들인 데이터를 사용해서 객체를 복원(역직렬화)한다.
		Object obj = ois.readObject();
//		System.out.println(obj);
		Employee emp = (Employee)obj;
		System.out.println("이름 : " + emp.getName());
		System.out.println("직위 : " + emp.getPosition());
		System.out.println("비번 : " + emp.getPassword());
		System.out.println("가족 : " + emp.getChild().getName());
		System.out.println("가족수 : " + emp.getChild().getCount());
		
		ois.close();
	}
}
