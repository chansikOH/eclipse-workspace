package demo4;

public class AnimalApp {

	public static void main(String[] args) {
		
		Animal a = new Dog();
		Animal b = new Cat();
		
		Dog c = (Dog) a;
		Cat d = (Cat) b;
		
		Dog e = (Dog) b;	// 형변환 예외 발생	
	}
}
