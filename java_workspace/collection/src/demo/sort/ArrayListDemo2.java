package demo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		ArrayList<Fruit> box = new ArrayList<Fruit>();
		box.add(new Fruit("사과", 2000));
		box.add(new Fruit("바나나", 6000));
		box.add(new Fruit("오렌지", 3000));
		box.add(new Fruit("아보카도", 8000));
		box.add(new Fruit("토마토", 4000));
		box.add(new Fruit("감", 9000));
		
		Comparator<Fruit> priceComparator = new Comparator<Fruit>() {
			public int compare(Fruit o1, Fruit o2) {
				return o1.getPrice() - o2.getPrice();
			}			
		};
		
		Collections.sort(box, priceComparator);
		
		for(Fruit fruit : box) {
			System.out.println(fruit.getName() + "," + fruit.getPrice());
		}
	}
}
