package demo.set;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetDemo2 {

	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random random = new Random();
		
		while (true) {
			int number = random.nextInt(45) + 1;
			lotto.add(number);
			
			if (lotto.size() == 6) {
				break;
			}
		}
		System.out.println(lotto);
	}
}
