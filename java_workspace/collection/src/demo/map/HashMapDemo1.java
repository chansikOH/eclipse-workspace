package demo.map;

import java.util.HashMap;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
//		put(K key, V value)
//		Map객체에 키,값 쌍으로 저장하기
		map.put(100, "홍길동");
		map.put(101, "김유신");
		map.put(102, "강감찬");
		map.put(103, "이순신");
		
//		V get(Oject key)
//		Map객체에서 지정된 키에 해당하는 값 꺼내기
		String value1 = map.get(101);
		System.out.println(value1);
		
//		V remove(Object key)
//		Map객체에서 지정된 키에 해당하는 값을 반환하고 삭제하기
		map.remove(102);
		
		boolean empty = map.isEmpty();
		System.out.println("비어있는가? " + empty);
		
		int len = map.size();
		System.out.println("저장된 갯수: " + len);
		
		map.clear();
		
		System.out.println(map);
	}
}
