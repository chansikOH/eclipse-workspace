package demo.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileReader reader = new FileReader("c:/temp/data.");
		BufferedReader br = new BufferedReader(reader);
		
		/*
		String text1 = br.readLine();
		String text2 = br.readLine();
		String text3 = br.readLine();
		String text4 = br.readLine();
		
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
		System.out.println(text4);
		*/
		
		String text = null;
		while ((text = br.readLine()) != null) {
			System.out.println(text);
		}
		
		br.close();
	}
}
