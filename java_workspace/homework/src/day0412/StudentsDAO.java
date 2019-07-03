package day0412;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.ConnectionUtils;

public class StudentsDAO {

	public StudentVO getStudent(String id) throws Exception {
		StudentVO student = null;
		
		String sql = "select "
				+ "stud_id, "
				+ "stud_name, "
				+ "stud_password, "
				+ "stud_grade, "
				+ "stud_status, "
				+ "stud_create_date, "
				+ "stud_req_status, "
				+ "dept_no "
				+ "from tb_students "
				+ "where stud_id = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			student = new StudentVO();
			student.setId(rs.getString("stud_id"));
			student.setName(rs.getString("stud_name"));
			student.setPassword(rs.getString("stud_password"));
			student.setGrade(rs.getInt("stud_grade"));
			student.setStatus(rs.getString("stud_status"));
			student.setCreateDate(rs.getDate("stud_create_date"));
			student.setReqStatus(rs.getString("stud_req_status"));
			student.setDeptNo(rs.getInt("dept_no"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return student;
	}
	
	public ArrayList<CourseVO> searchCourseByDept(String id) throws Exception {
		ArrayList<CourseVO> cour = new ArrayList<CourseVO>();
		
		String sql = "select "
				+ "C.course_no, "
				+ "C.prof_id, "
				+ "C.dept_no, "
				+ "D.dept_name, "
				+ "C.course_name, "
				+ "C.course_create_date, "
				+ "C.course_quota "
				+ "from tb_courses C, tb_students S, tb_departments D "
				+ "where C.dept_no = S.dept_no "
				+ "and S.dept_no = D.dept_no "
				+ "and S.stud_id = ? "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			CourseVO cou = new CourseVO();
			cou.setNo(rs.getInt("course_no"));
			cou.setProfId(rs.getString("prof_id"));
			cou.setDeptNo(rs.getInt("dept_no"));
			cou.setDeptName(rs.getString("dept_name"));
			cou.setName(rs.getString("course_name"));
			cou.setCreateDate(rs.getDate("course_create_date"));
			cou.setQuota(rs.getInt("course_quota"));
			
			cour.add(cou);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return cour;
	}
	
	public ArrayList<CourseRequestListVO> searchCourseReqById(String id) throws Exception {
		ArrayList<CourseRequestListVO> courseReq = new ArrayList<CourseRequestListVO>();
		
		String sql = "select "
				+ "R.req_no, "
				+ "R.course_no, "
				+ "C.course_name, "
				+ "R.req_create_date, "
				+ "R.course_score "
				+ "from tb_course_request_list R, tb_courses C "
				+ "where R.course_no = C.course_no "
				+ "and R.stud_id = ? "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			CourseRequestListVO couRe = new CourseRequestListVO();
			couRe.setReqNo(rs.getInt("req_no"));
			couRe.setCourseNo(rs.getInt("course_no"));
			couRe.setCourseName(rs.getString("course_name"));
			couRe.setCreateDate(rs.getDate("req_create_date"));
			couRe.setCourseScore(rs.getInt("course_score"));
			
			courseReq.add(couRe);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return courseReq;
	}

	public void requestCourse(int courseNo, String id) throws Exception {
		String sql = "insert into tb_course_request_list "
				+ "(req_no, course_no, stud_id) "
				+ "values (school_seq.nextval, ?, ?) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, courseNo);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void deleteCourseReq(int courseNo, String id) throws Exception {
		String sql = "delete from tb_course_request_list "
				+ "where course_no = ? "
				+ "and stud_id = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, courseNo);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void updateStatus(String status, String id) throws Exception{
		String sql = "update tb_students "
				+ "set "
				+ "stud_status = ?, "
				+ "stud_req_status = 'N' "
				+ "where stud_id = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}
