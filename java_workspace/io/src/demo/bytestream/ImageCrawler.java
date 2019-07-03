package demo.bytestream;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class ImageCrawler {

	public static void main(String[] args) throws Exception{
		
		URL url = new URL("https://img2.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/201903/26/newsen/20190326101733645qadi.jpg");
		
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("c:/temp/lee.jpg");
		
		int value = 0;
		while ((value = in.read()) != -1) {
			out.write(value);
		}
		
		in.close();
		out.close();
	}
}
