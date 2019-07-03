package demo4;

import java.util.Arrays;

public class SystemDemo3 {

	public static void main(String[] args) {
		
		/*
		 * 배열복사
		 * void System.arrarycopy(Object src, int srcPos, Object dest, int destPos, int length)
		 * src : 원본배열
		 * srcPos : 원본배열의 복사 시작위치
		 * dest : 목적지 배열
		 * destPos : 목적지배열의 데이터 삽입 시작위치
		 * length : 복사할 배열의 아이템 개수 
		 */
		String[] src = {"사과", "배", "바나나", "토마토", "레몬", "감", "포도", "오렌지", "멜론"};
		String[] dest1 = new String[5];
		String[] dest2 = new String[10];
		
		System.arraycopy(src, 3, dest1, 0, 5);
		System.arraycopy(src, 0, dest2, 4, 6);
		
		System.out.println(Arrays.toString(dest1));
		System.out.println(Arrays.toString(dest2));
		
		
		
	}
}
