package demo.thread;

public class YourThread extends Thread{

	@Override
	public void run() {
		super.run();
		System.out.println("YourThread의 run() 메소드 실행 시작");
		
		for (int i=0; i<1000; i++) {
			System.out.println("YourThread 실행 중 " + i);
		}
		
		System.out.println("YourThread의 run() 메소드 실행 종료");
	}
}
