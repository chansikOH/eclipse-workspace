package day0315;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		int position = 0;
		
		Random random = new Random();
		
		while (true) {			
			int no = random.nextInt(45) + 1;
			boolean isThere = false;
			for(int num : lotto) {
				if (num == no) {
					isThere = true;
					break;
				}
			}
			if(!isThere) {
				lotto[position++] = no;
			}
			if(position == 6) {
				break;
			}
		}
		Arrays.sort(lotto);
		System.out.println("[이번주 당첨 숫자]");
		System.out.println(Arrays.toString(lotto));
	}
}
