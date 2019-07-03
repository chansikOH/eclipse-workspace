package demo.file;

import java.io.File;

public class FileDemo3 {

	public static void main(String[] args) {
		
		File dir = new File("c:/temp/source");
		dir.mkdir();
		
		File dirs = new File("c:/temp/resource/image/logo");
		dirs.mkdirs();
	}
}
