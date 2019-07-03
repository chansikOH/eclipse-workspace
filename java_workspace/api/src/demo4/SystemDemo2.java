package demo4;

import java.util.Properties;
import java.util.Set;

public class SystemDemo2 {

	public static void main(String[] args) {
		Properties prop = System.getProperties();
		
		Set<Object> keys = prop.keySet();
		for (Object key : keys) {
			String value = prop.getProperty(key.toString());
			System.out.println("["+key+"]" + value);
		}
	}
}
