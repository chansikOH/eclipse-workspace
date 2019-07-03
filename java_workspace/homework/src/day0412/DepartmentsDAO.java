package day0412;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.ConnectionUtils;

public class DepartmentsDAO {

	public DepartmentVO getDepartment(String deptName) throws Exception {
		DepartmentVO dept = null;
		
		String sql = "select dept_no, dept_name "
				+ "from tb_departments "
				+ "where dept_name = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, deptName);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			dept = new DepartmentVO();
			dept.setNo(rs.getInt("dept_no"));
			dept.setName(rs.getString("dept_name"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return dept;
	}
	
	public ArrayList<DepartmentVO> searchAlldepartments() throws Exception {
		ArrayList<DepartmentVO> dept = new ArrayList<DepartmentVO>();
		
		String sql = "select dept_no, dept_name "
				+ "from tb_departments "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			DepartmentVO dep = new DepartmentVO();
			dep.setNo(rs.getInt("dept_no"));
			dep.setName(rs.getString("dept_name"));
			
			dept.add(dep);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return dept;
	}
}
