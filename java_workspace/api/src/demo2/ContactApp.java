package demo2;

public class ContactApp {

	public static void main(String[] args) {
		
		Contact c = new Contact(10, "김유신", "010-1111-1111", "kim@naver.com");
		Contact cc = new Contact(10, "김유신", "010-1111-1111", "kim@naver.com");
		
		// int hashcode() : 객체에 부여된 일련번호를 정수로 제공하는 메소드
		int hash = c.hashCode();
		int hash2 = cc.hashCode();
		
		System.out.println("해쉬코드값 : " + hash);
		System.out.println("해쉬코드값 : " + hash2);
		
		// String toString() :  - 객체의 정보를 문자열로 제공하는 메소드
		// 						- 설계도의 이름 + @ + 해시코드값(16진수)
		//						- toString() 메소드는 재정의해서 필드에 저장된 값들을 문자열로 
		//						  이어서 제공하도록 재정의해서 사용한다.
		String info = c.toString();
		String info2 = cc.toString();
			
		System.out.println("객체의 정보 : " + info); 
		System.out.println("객체의 정보 : " + info2);
		// System.out.println(c);
		// System.out.println(cc);
		// System.out.println(c.toString());
		// System.out.println(cc.toString());
		
		// boolean equals(Object other) : - 전달받은 다른객체와 이 객체가
		//									동일한 객체인지 여부를 반환한다.
		boolean res1 = c.equals(cc);
		boolean res2 = cc.equals(c);
		System.out.println(res1);
		System.out.println(res2);
	}
}
