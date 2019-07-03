package demo2;

public class MyRuntimeExceptionDemo1 {

	public static void printArray(String[] items) throws MyRuntimeException {
		if (items == null || items.length == 0) {
			throw new MyRuntimeException("배열이 null이거나 길이가 0입니다.");
		}
		
		for (String item : items) {
			System.out.println(item);
		}
	}
	
	public static void main(String[] args) {
		String[] teamNames = {"영업팀", "서울팀", "경기팀"};
		String[] studentNames = null;
		
		MyRuntimeExceptionDemo1.printArray(teamNames);
		MyRuntimeExceptionDemo1.printArray(studentNames);
	}
}
