package day0412;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.ConnectionUtils;

public class EmployeesDAO {

	public EmployeeVO getEmployee(String id) throws Exception {
		EmployeeVO emp = null;
		
		String sql = "select "
				+ "emp_id, "
				+ "emp_name, "
				+ "emp_password, "
				+ "emp_phone, "
				+ "emp_hiredate, "
				+ "emp_working, "
				+ "emp_create_date "
				+ "from tb_employees "
				+ "where emp_id = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			emp = new EmployeeVO();
			emp.setId(rs.getString("emp_id"));
			emp.setName(rs.getString("emp_name"));
			emp.setPassword(rs.getString("emp_password"));
			emp.setPhone(rs.getString("emp_phone"));
			emp.setHireDate(rs.getDate("emp_hiredate"));
			emp.setWorking(rs.getString("emp_working"));
			emp.setCreateDate(rs.getDate("emp_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
			
		return emp;
	}
	
	public void addDepartment(String deptName) throws Exception {
		
		String sql = "insert into tb_departments (dept_no, dept_name) "
				+ "values(school_seq.nextval, ?) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, deptName);
		pstmt.executeUpdate();
		
		pstmt.close();		
		con.close();
	}
	
	public void addProfessor(ProfessorVO professor)throws Exception {
		String sql = "insert into tb_professor"
				+ "(prof_id, prof_name, prof_password, prof_position, dept_no) "
				+ "values (?, ?, ?, ?, ?) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, professor.getId());
		pstmt.setString(2, professor.getName());
		pstmt.setString(3, professor.getPassword());
		pstmt.setString(4, professor.getPosition());
		pstmt.setInt(5, professor.getDeptNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();	
	}
	
	public void addStudent(StudentVO student) throws Exception {
		String sql = "insert into tb_students "
				+ "(stud_id, stud_name, stud_password, stud_grade, stud_status, dept_no) "
				+ "values (?, ?, ?, ?, ?, ?) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getId());
		pstmt.setString(2, student.getName());
		pstmt.setString(3, student.getPassword());
		pstmt.setInt(4, student.getGrade());
		pstmt.setString(5, student.getStatus());
		pstmt.setInt(6, student.getDeptNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void updateStudReqStatus(String id) throws Exception {
		String sql = "update tb_students "
				+ "set "
				+ "stud_req_status = 'Y' "
				+ "where stud_req_status = 'N' "
				+ "and stud_id = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<ProfessorVO> searchAllProf() throws Exception {
		ArrayList<ProfessorVO> prof = new ArrayList<ProfessorVO>();
		
		String sql =  "select "
				+ "P.prof_id, "
				+ "P.prof_name, "
				+ "P.prof_password, "
				+ "P.prof_position, "
				+ "P.prof_hiredate, "
				+ "P.prof_working, "
				+ "P.prof_create_date, "
				+ "P.dept_no, "
				+ "D.dept_name "
				+ "from tb_professor P, tb_departments D "
				+ "where P.dept_no = D.dept_no "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ProfessorVO professor = new ProfessorVO();
			professor.setId(rs.getString("prof_id"));			
			professor.setName(rs.getString("prof_name"));			
			professor.setPassword(rs.getString("prof_password"));			
			professor.setPosition(rs.getString("prof_position"));			
			professor.setHireDate(rs.getDate("prof_hiredate"));			
			professor.setWorking(rs.getString("prof_working"));			
			professor.setCreateDate(rs.getDate("prof_create_date"));			
			professor.setDeptNo(rs.getInt("dept_no"));
			professor.setDeptName(rs.getString("dept_name"));
			
			prof.add(professor);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return prof;
	}
	
	public ArrayList<StudentVO> searchAllStud() throws Exception {
		ArrayList<StudentVO> stud = new ArrayList<StudentVO>();
		
		String sql = "select "
				+ "S.stud_id, "
				+ "S.stud_name, "
				+ "S.stud_password, "
				+ "S.stud_grade, "
				+ "S.stud_status, "
				+ "S.stud_create_date, "
				+ "S.stud_req_status, "
				+ "S.dept_no, "
				+ "D.dept_name "
				+ "from tb_students S, tb_departments D "
				+ "where S.dept_no = D.dept_no "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			StudentVO stu = new StudentVO();
			stu.setId(rs.getString("stud_id"));
			stu.setName(rs.getString("stud_name"));
			stu.setPassword(rs.getString("stud_password"));
			stu.setGrade(rs.getInt("stud_grade"));
			stu.setStatus(rs.getString("stud_status"));
			stu.setCreateDate(rs.getDate("stud_create_date"));
			stu.setReqStatus(rs.getString("stud_req_status"));
			stu.setDeptNo(rs.getInt("dept_no"));
			stu.setDeptName(rs.getString("dept_name"));
			
			stud.add(stu);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return stud;
	}
}
