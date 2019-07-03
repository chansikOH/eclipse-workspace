package demo.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo1 {

	public static void main(String[] args) throws Exception{
		
		Family f = new Family("자녀", 2);
		Employee employee = new Employee();
		employee.setName("홍길동");
		employee.setPosition("과장");
		employee.setPassword(1234);
		employee.setChild(f);
		
		FileOutputStream fos = new FileOutputStream("c:/temp/emp.sav");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// void writeObject(Object o)
		// 객체를 직렬화한다.
		oos.writeObject(employee);
		
		oos.close();
	}
}
