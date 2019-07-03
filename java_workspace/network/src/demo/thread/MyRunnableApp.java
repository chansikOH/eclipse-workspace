package demo.thread;

public class MyRunnableApp {

	public static void main(String[] args) {
		
		System.out.println("메인 메소드 시작");
		
		MyRunnable my = new MyRunnable();
		Thread t = new Thread(my);
		t.start();
		
		for (int i=0; i<100; i++) {
			System.out.println("메인 메소드 실행 " + i);
		}
		
		System.out.println("메인 메소드 종료");
	}
}
