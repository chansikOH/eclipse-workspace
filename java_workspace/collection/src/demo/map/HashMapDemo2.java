package demo.map;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapDemo2 {

	public static void main(String[] args) {
		
		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		
		HashSet<String> team1 = new HashSet<String>();
		team1.add("바다");
		team1.add("유진");
		team1.add("슈");
		
		HashSet<String> team2 = new HashSet<String>();
		team2.add("솔라");
		team2.add("문별");
		team2.add("휘인");
		team2.add("화사");
		
		HashSet<String> team3 = new HashSet<String>();
		team3.add("웬디");
		team3.add("아이린");
		team3.add("슬기");
		team3.add("조이");
		team3.add("예리");
		
		map.put("SES", team1);
		map.put("마마무", team2);
		map.put("레드벨벳", team3);
		
		HashSet<String> names = map.get("레드벨벳");
		for (String name : names) {
			System.out.println(name);
		}
		
	}
}
