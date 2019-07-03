package demo.properties;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception{
		
		Properties prop = new Properties();
		
		FileReader reader = new FileReader("src/demo/properties/config.properties");
		// void load(Reader reader)
		// FileReader 객체를 사용해서 파일의 정보를 읽어온다.
		prop.load(reader);
		// String getProperty(String key)
		// 프로퍼티 파일에서 지정된 키값으로 설정된 값을 반환한다.
		String value1 = prop.getProperty("user.name");
		System.out.println(value1);
		
		String value2 = prop.getProperty("user.password");
		System.out.println(value2);
		
		String value3 = prop.getProperty("user.role");
		System.out.println(value3);
		
		String value4 = prop.getProperty("select.users");
		System.out.println(value4);
	}
}
