package demo.reader;

import java.io.BufferedReader;
import java.io.FileReader;

public class BurfferedReaderDemo2 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("c:/temp/data.csv"));
		
		int totalEventCount = 0;
		
		String text = null;
		while ((text = reader.readLine()) != null) {
			String[] items = text.split(",");
			
			// 사고발생 지역
			String location = items[5].replace("\"", "");
			if (location.startsWith("서울특별시")) {
				// 발생건수
				int event = Integer.parseInt(items[6]);
				totalEventCount += event;
			}
		}
		System.out.println("서울지역 발생건수 : " + totalEventCount);
		
		reader.close();
	}
}
