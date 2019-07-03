package demo.thread;

public class ThreadApp {

	public static void main(String[] args) {
		
		System.out.println("메인 메소드 실행 시작");
		
		MyThread my = new MyThread();
		YourThread your = new YourThread();
		
		my.start();
		your.start();
		
		for(int i=0; i<1000; i++) {
			System.out.println("메인스레드 실행 " + i);
		}
		
		System.out.println("메인 메소드 실행 종료");
	}
}
