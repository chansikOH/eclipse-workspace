package demo.sync;

public class ATMApp {

	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread t1 = new Thread(atm);
		Thread t2 = new Thread(atm);
		Thread t3 = new Thread(atm);
		Thread t4 = new Thread(atm);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}