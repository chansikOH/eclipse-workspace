package kr.co.hta.ibatis;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.hta.util.IbatisUtils;

public class LocationDao {
	SqlMapClient sqlMap = IbatisUtils.getSqlMap();

	public void insertLocation(Location location) throws Exception {
		sqlMap.insert("insertLocation", location);
	}
	
	public void deleteLocationById(int locationId) throws Exception {
		sqlMap.delete("deleteLocationById", locationId);
	}
	
	public int getAllCount() throws Exception {
		return (Integer) sqlMap.queryForObject("getAllCount");
	}
	
	public int getCountByCountry(String countryId) throws Exception {
		return (Integer) sqlMap.queryForObject("getCountByCountry", countryId);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getAllCities() throws Exception {
		return (List<String>) sqlMap.queryForList("getAllCities");
	}
	
	public Location getLocationById(int countryId) throws Exception {
		return (Location) sqlMap.queryForObject("getLocationById", countryId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Location> getLocationByCountry(String countryId) throws Exception {
		return (List<Location>) sqlMap.queryForList("getLocationByCountry", countryId);
	}
	
}
