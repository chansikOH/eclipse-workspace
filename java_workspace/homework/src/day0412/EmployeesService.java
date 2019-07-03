package day0412;

import java.util.ArrayList;

public class EmployeesService {

	EmployeesDAO empDao = new EmployeesDAO();
	DepartmentsDAO deptDao = new DepartmentsDAO();
	ProfessorDAO proDao = new ProfessorDAO();
	StudentsDAO stuDao = new StudentsDAO();
	
	public boolean login(String id, String password) throws Exception{
		boolean isSuccess = false;
		EmployeeVO emp = empDao.getEmployee(id);

		if(emp == null) {
			throw new Exception("아이디가 틀렸습니다.");
		}
		
		if(!emp.getPassword().equals(password)) {
			throw new Exception("비밀번호가 틀렸습니다.");
		}
		
		isSuccess = true;
		
		return isSuccess;
	}
	
	public void addDepartment(String deptName) throws Exception {
		DepartmentVO dept = deptDao.getDepartment(deptName);
		
		if(dept != null) {
			throw new Exception("동일한 학과가 존재합니다.");
		}
		
		empDao.addDepartment(deptName);		
	}
	
	public void addProfessor(ProfessorVO professor) throws Exception{
		ProfessorVO pro = proDao.getProfessor(professor.getId());
		
		if(pro != null) {
			throw new Exception("동일한 아이디가 존재합니다.");
		}
		
		empDao.addProfessor(professor);
	}
	
	public void addStudent(StudentVO student) throws Exception {
		StudentVO stud = stuDao.getStudent(student.getId());
		
		if (stud != null) {
			throw new Exception("동일한 아이디가 존재합니다.");
		}
		
		empDao.addStudent(student);
	}
	
	public void updateStudReqStatus(String id) throws Exception {
		empDao.updateStudReqStatus(id);
	}
	
	public ArrayList<ProfessorVO> searchAllProf() throws Exception {
		ArrayList<ProfessorVO> prof = empDao.searchAllProf();
		
		return prof;
	}
	
	public ArrayList<StudentVO> searchAllStud() throws Exception {
		ArrayList<StudentVO> stud = empDao.searchAllStud();
		
		return stud;
	}
	
}
