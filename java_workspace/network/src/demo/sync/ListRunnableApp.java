package demo.sync;

public class ListRunnableApp {

	public static void main(String[] args) {
		
		ListRunnable work = new ListRunnable();
		
		Thread t1 = new Thread(work);
		Thread t2 = new Thread(work);
		Thread t3 = new Thread(work);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
