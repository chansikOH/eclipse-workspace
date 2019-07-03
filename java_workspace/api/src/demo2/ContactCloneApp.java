package demo2;

public class ContactCloneApp {
	
	public static void main(String[] args) throws Exception{
		
		Contact src = new Contact(100, "홍길동", "010-1111-1111", "hong@gamil.com");
		
		Contact cloneContact = src.copyContact();
		System.out.println(cloneContact.getNo());
		System.out.println(cloneContact.getName());
		System.out.println(cloneContact.getTel());
		System.out.println(cloneContact.getEmail());
	}
}
