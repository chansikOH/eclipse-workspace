package kr.co.hta.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.hta.hr.vo.Department;
import kr.co.hta.util.ConnectionUtils;

public class DepartmentDao {

	// 모든 부서정보 조회기능
	public ArrayList<Department> selectAllDepartments() throws Exception{
		ArrayList<Department> departments = new ArrayList<>();
		
		String sql = "select department_id, department_name, manager_id, location_id "
				+ "from departments ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Department department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			department.setManagerId(rs.getInt("manager_id"));
			department.setLocationId(rs.getInt("location_id"));
			
			departments.add(department);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return departments;
	}

}
