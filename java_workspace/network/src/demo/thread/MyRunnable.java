package demo.thread;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("MyRunnable run 실행 시작");
		
		for (int i=0; i<100; i++) {
			System.out.println("MyRunnable 실행 " + i);
		}
		
		System.out.println("MyRunnable run 실행 종료");
	}
}
