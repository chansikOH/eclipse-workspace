package day0412;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.ConnectionUtils;

public class CourseDAO {

	public ArrayList<CourseVO> searchAllCourse() throws Exception{
		ArrayList<CourseVO> course = new ArrayList<CourseVO>();
		
		String sql = "select "
				+ "C.course_no, "
				+ "C.prof_id, "
				+ "C.dept_no, "
				+ "D.dept_name, "
				+ "C.course_name, "
				+ "C.course_create_date, "
				+ "C.course_quota "
				+ "from tb_courses C, tb_departments D "
				+ "where C.dept_no = D.dept_no "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CourseVO cour = new CourseVO();
			cour.setNo(rs.getInt("course_no"));
			cour.setProfId(rs.getString("prof_id"));
			cour.setDeptNo(rs.getInt("dept_no"));
			cour.setDeptName(rs.getString("dept_name"));
			cour.setName(rs.getString("course_name"));
			cour.setCreateDate(rs.getDate("course_create_date"));
			cour.setQuota(rs.getInt("course_quota"));
			
			course.add(cour);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return course;
	}
	
	public CourseVO getCourse(int courseNo) throws Exception{
		CourseVO cour = null;
		
		String sql = "select "
				+ "C.course_no, "
				+ "C.prof_id, "
				+ "C.dept_no, "
				+ "D.dept_name, "
				+ "C.course_name, "
				+ "C.course_create_date, "
				+ "C.course_quota "
				+ "from tb_courses C, tb_departments D "
				+ "where C.dept_no = D.dept_no "
				+ "and C.course_no = ? "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, courseNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			cour = new CourseVO();
			cour.setNo(rs.getInt("course_no"));
			cour.setProfId(rs.getString("prof_id"));
			cour.setDeptNo(rs.getInt("dept_no"));
			cour.setDeptName(rs.getString("dept_name"));
			cour.setName(rs.getString("course_name"));
			cour.setCreateDate(rs.getDate("course_create_date"));
			cour.setQuota(rs.getInt("course_quota"));
			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return cour;
	}
}
