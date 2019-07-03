package demo.file;

import java.io.File;

public class FileDemo5 {

	public static void main(String[] args) {
		
		File file1 = new File("c:/temp/source/a.txt");
		file1.delete();
		
		File file2 = new File("c:/temp/source/b.txt");
		file2.delete();
		
		File dir = new File("c:/temp/source");
		dir.delete();
	}
}
