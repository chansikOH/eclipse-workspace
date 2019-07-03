package demo.sync;

public class ATM implements Runnable {

	private long balance = 1000000;
	
	@Override
	public void run() {
		for(int i=0; i<25; i++) {
			출금();
		}
	}
	
	public synchronized void 출금() {
		System.out.println("현재 잔액 : " + balance);
		System.out.println("출금시작");
		balance -= 10000;
		System.out.println("출금종료");
		System.out.println("출금 후 잔액 : " + balance);
	}
}
