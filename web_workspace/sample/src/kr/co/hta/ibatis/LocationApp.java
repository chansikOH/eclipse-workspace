package kr.co.hta.ibatis;

import java.util.List;

public class LocationApp {

	public static void main(String[] args) throws Exception {
		
		LocationDao dao = new LocationDao();
		
//		Location location = new Location();
//		location.setAddress("간석동");
//		location.setCode("12345");
//		location.setCity("인천");
//		location.setState("경기도");
//		location.setCountryId("US");
//		
//		dao.insertLocation(location); 
		
		int value1 = dao.getAllCount();
		System.out.println("총 지역 개수 : " + value1);
		
		int value2 = dao.getCountByCountry("US");
		System.out.println("미국의 지역 수 : " + value2);
		
		List<String> cities = dao.getAllCities();
		for (String city : cities) {
			System.out.println("지역명 : " + city);
		}
		
		Location location = dao.getLocationById(1700);
		System.out.println(location.getId());
		System.out.println(location.getAddress());
		System.out.println(location.getCity());
		System.out.println(location.getCode());
		System.out.println(location.getState());
		System.out.println(location.getCountryId());
		
		List<Location> locations = dao.getLocationByCountry("US");
		for(Location loc : locations) {
			System.out.println(loc.getId() + ", " + loc.getAddress() + ", " + loc.getCity());
		}
	}
}
