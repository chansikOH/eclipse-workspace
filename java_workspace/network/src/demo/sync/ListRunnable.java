package demo.sync;

import java.util.ArrayList;
import java.util.Vector;

public class ListRunnable implements Runnable{

	
	@Override
	public void run() {
		ArrayList<String> names = new ArrayList<String>();
		
		for (int i=0; i<100; i++) {
			names.add("홍길동" +i);
		}
	}
}
