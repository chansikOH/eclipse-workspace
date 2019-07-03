package day0325;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AccidentService {

	// 모든 사고정보를 저장하는 콜렉션
	private List<Accident> data = new ArrayList<Accident>();
	
	// data.csv 파일의 정보를 로드한다. 
	public void load() throws Exception{
		// 1. BufferedReader 객체를 생성한다.
		// 2. 텍스트 한 줄을 저장할 String 변수를 생성한다.
		// 3. 텍스트를 읽어온다. <-- while문 사용
		// 		텍스트를 자른다.
		//		항목을 가져온다.
		//		Accident 객체를 생성한다.
		//		Accident 객체에 각 항목의 값을 담는다.
		//		Accident 객체를 ArrayList에 저장한다.
		// 4. close()를 실행한다.
		BufferedReader reader = new BufferedReader(new FileReader("c:/temp/data.csv"));
		
		String text = null;
		while((text = reader.readLine()) != null) {
			String[] items = text.split(",");
			String location = items[5].replace("\"", "");
			int count = Integer.parseInt(items[6]);
			int both = Integer.parseInt(items[7]);
			int death = Integer.parseInt(items[8]);
			
			Accident accident = new Accident();
			accident.setLocation(location);
			accident.setCount(count);
			accident.setBoth(both);
			accident.setDeath(death);
			
			data.add(accident);
		}
		reader.close();
	}
	
	// 지역명을 전달받아서 그 지역의 전체발생건수, 전체 사망자수, 전체 사상자수를 출력한다.
	public void printAccidentInfo(String locationName) {
		System.out.println("[" + locationName + " 사고 현황]");
		int totalCount = 0;
		int totalDeath = 0;
		int totalBoth = 0;
		for (Accident accident : data) {
			String location = accident.getLocation();
			if (location.startsWith(locationName)) {
				totalCount += accident.getCount();
				totalDeath += accident.getDeath();
				totalBoth += accident.getBoth();
			}
		}
		System.out.println("전체 발생건수 : " + totalCount);
		System.out.println("전체 사망자수 : " + totalDeath);
		System.out.println("전체 사상자수 : " + totalBoth);
	}
	
	// 전체 발생건수를 출력한다.
	public void printTotalAccidentCount() {
		int totalCount = 0;
		for (Accident accident : data) {
			totalCount += accident.getCount();
		}
		System.out.println("전체 발생건수 : " + totalCount);
	}
	
	// 전체 사망자수를 출력한다.
	public void printTotalDeaths() {
		int totalDeath = 0;
		for (Accident accident : data) {
			totalDeath += accident.getDeath();
		}
		System.out.println("전체 사망자수 : " + totalDeath);
	}
	
	// 전체 사상자수를 출력한다.
	public void printTotalBoth() {
		int totalBoth = 0;
		for (Accident accident : data) {
			totalBoth += accident.getBoth();
		}
		System.out.println("전체 사상자수 : " + totalBoth);
	}
}
