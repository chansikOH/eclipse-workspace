package day0409;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HRService {

	// 사원아이디를 입력받아서 사원아이디, 이름, 직종아이디, 급여, 커미션, 부서아이디, 부서이름을 조회하는 기능
	public void searchByEmployeeID (int employeeID) throws Exception {
		String sql = "select "
				+ "E.employee_id Eid, "
				+ "E.first_name Ename, "
				+ "E.job_id Ejid, "
				+ "E.salary Esal, "
				+ "E.commission_pct Ecomm, "
				+ "E.department_id Edept, "
				+ "D.department_name Dname "
				+ "from employees E, departments D "
				+ "where E.department_id = D.department_id "
				+ "and E.employee_id = ? "
				+ "order by 1 ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, employeeID);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("Eid");
			String name = rs.getString("Ename");
			String job = rs.getString("Ejid");
			double eSal = rs.getDouble("Esal");
			double comm = rs.getDouble("Ecomm");
			int eDept = rs.getInt("Edept");
			String dName = rs.getString("Dname");
			
			System.out.println(id + ", " + name + ", " + job + ", "+ eSal +", " + comm + ", " + eDept + ", " + dName);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
	
	// 입사년도를 입력받아서 사원아이디, 이름, 입사일, 부서이름을 조회하는 기능
	public void searchByYear (int year) throws Exception {
		String sql = "select "
				+ "E.employee_id id, "
				+ "E.first_name name, "
				+ "E.hire_date \"date\", "
				+ "D.department_name dept "
				+ "from employees E, departments D "
				+ "where E.department_id = D.department_id "
				+ "and to_char(hire_date, 'yyyy') = ? "
				+ "order by 1 ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, year);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Date date = rs.getDate("date");
			String dept = rs.getString("dept");
			
			System.out.println(id + ", " + name + ", " + date + ", " + dept);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
	
	// 급여등급을 입력받아서 사원아이디, 이름, 급여, 급여등급을 조회하는 기능
	public void searchByJobGrade (String jobGrade) throws Exception {
		String sql = "select "
				+ "E.employee_id id, "
				+ "E.first_name name, "
				+ "E.salary salary, "
				+ "J.gra grade "
				+ "from employees E, job_grades J "
				+ "where E.salary >= J.lowest_salary and E.salary <= J.highest_salary "
				+ "and J.gra = ? "
				+ "order by 1 ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		String gra = jobGrade;
		pstmt.setString(1, gra.toUpperCase());
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double salary = rs.getDouble("salary");
			String grade = rs.getString("grade");
			
			System.out.println(id + ", " + name + ", " + salary + ", " + grade);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
	
	// 부서아이디를 입력받아서 사원아이디, 이름, 부서아이디, 부서이름을 조회하는 기능
	public void searchByDepartmentID (int departmentID) throws Exception {
		String sql = "select "
				+ "E.employee_id id, "
				+ "E.first_name name, "
				+ "E.department_id dept_id, "
				+ "D.department_name dept_name "
				+ "from employees E, departments D "
				+ "where E.department_id = D.department_id "
				+ "and E.department_id = ? "
				+ "order by 1 ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, departmentID);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int deptID = rs.getInt("dept_id");
			String deptName = rs.getString("dept_name");
			
			System.out.println(id + ", " + name + ", " + deptID + ", " + deptName);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
	
	// 관리자 이름을 입력받아서 해당 관리자에게 보고하는 직원의 아이디, 이름, 입사일을 조회하는 기능
	public void searchByManagerName (String managerName) throws Exception {
		String sql = "select "
				+ "E.employee_id id, "
				+ "E.first_name name, "
				+ "E.hire_date \"date\" "
				+ "from employees E, employees M "
				+ "where E.manager_id = M.employee_id "
				+ "and E.manager_id in (select employee_id from employees where first_name = ?) "
				+ "order by 1 ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, managerName);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Date date = rs.getDate("date");
			
			System.out.println(id + ", " + name + ", " + date);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
}
