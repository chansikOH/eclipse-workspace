package demo.bytestream;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class ImageCrawler2 {

	public static void main(String[] args) throws Exception{
		
		URL url = new URL("https://img1.daumcdn.net/thumb/R720x0/?fname=https://t1.daumcdn.net/liveboard/feelthemovie/79e8ad7a28b24c97864dd7e1b11e0432.jpeg");
		
		InputStream in = url.openStream();
		OutputStream out = new FileOutputStream("c:/temp/샤잠.jpeg");
		
		IOUtils.copy(in, out);
			
	}
}
