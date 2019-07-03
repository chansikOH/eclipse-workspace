package demo.thread;

public class MyThread extends Thread{

	@Override
	public void run() {
		super.run();
		System.out.println("MyThread의 run() 메소드 실행 시작");
		
		for (int i=0; i<1000; i++) {
			System.out.println("MyThread 실행 중 " + i);
		}
		
		System.out.println("MyThread의 run() 메소드 실행 종료");
	}
}
