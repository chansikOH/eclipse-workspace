package demo2;

public class MyExceptionDemo1 {

	/**
	 * 문자열 배열을 전달받아서 화면에 배열의 내용을 출력하는 메소드
	 * @param names 문자열 배열
	 * @throws MyException 배열이 null이거나 배열의 길이가 0인 경우 예외발생
	 */
	public static void printArray(String[] names) throws MyException {
		if(names == null || names.length == 0) {		// 예외상황
			// 예외 발생
			throw new MyException("null인 배열이 전달되었습니다.");
		}
		for (String item : names) {
			System.out.println(item);
		}
	}
	
	public static void main(String[] args) {
		
		String[] teamNames = {"영업팀", "서울팀", "경기팀"};
		String[] studentNames = null;
		try {
			MyExceptionDemo1.printArray(teamNames);
			MyExceptionDemo1.printArray(studentNames);
		} catch (MyException e) {
			e.printStackTrace();
		}
		
	}
}
