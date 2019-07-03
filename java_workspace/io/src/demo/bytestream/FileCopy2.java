package demo.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

public class FileCopy2 {

	public static void main(String[] args) throws Exception{
		
		InputStream in = new FileInputStream("c:/temp/nako.jpg");
		OutputStream out = new FileOutputStream("c:/temp/copy_copy_nako.jpg");
		
		IOUtils.copy(in, out);
	}
}
