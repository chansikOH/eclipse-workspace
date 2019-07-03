package demo4;

public class SystemDemo {

	public static void main(String[] args) {
		
		// 시스템의 현재 시간정보 조회하기(밀리초 단위)
		// long System.currentTimeMillies()
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		// 시스템 속성값 조회하기
		// String System.getProperty(String name)
		String value1 = System.getProperty("java.version");
		String value2 = System.getProperty("os.name");
		String value3 = System.getProperty("user.name");
		String value4 = System.getProperty("user.home");
		System.out.println("자바버전 : " + value1);
		System.out.println("운영체제이름 : " + value2);
		System.out.println("사용자 이름 : " + value3);
		System.out.println("사용자 홈 디렉토리 : " + value4);
		
		// 시스템의 환경변수값 조회
		// String System.getenv(String name)
		String env1 = System.getenv("JAVA_HOME");
		String env2 = System.getenv("Path");
		System.out.println("자바홈: " + env1);
		System.out.println("패스: " + env2);
		
		
		
		
	}
}
