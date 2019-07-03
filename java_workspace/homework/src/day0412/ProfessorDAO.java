package day0412;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.utils.ConnectionUtils;

public class ProfessorDAO {

	public ProfessorVO getProfessor(String id) throws Exception {
		ProfessorVO professor = null;
		
		String sql = "select "
				+ "prof_id, "
				+ "prof_name, "
				+ "prof_password, "
				+ "prof_position, "
				+ "prof_hiredate, "
				+ "prof_working, "
				+ "prof_create_date, "
				+ "dept_no "
				+ "from tb_professor "
				+ "where prof_id = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			professor = new ProfessorVO();
			professor.setId(rs.getString("prof_id"));			
			professor.setName(rs.getString("prof_name"));			
			professor.setPassword(rs.getString("prof_password"));			
			professor.setPosition(rs.getString("prof_position"));			
			professor.setHireDate(rs.getDate("prof_hiredate"));			
			professor.setWorking(rs.getString("prof_working"));			
			professor.setCreateDate(rs.getDate("prof_create_date"));			
			professor.setDeptNo(rs.getInt("dept_no"));			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return professor;
	}
}
