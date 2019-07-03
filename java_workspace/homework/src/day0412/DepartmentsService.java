package day0412;

import java.util.ArrayList;

public class DepartmentsService {

	EmployeesDAO empDao = new EmployeesDAO();
	DepartmentsDAO deptDao = new DepartmentsDAO();
	ProfessorDAO proDao = new ProfessorDAO();
	StudentsDAO stuDao = new StudentsDAO();
	
	public ArrayList<DepartmentVO> searchAllDept() throws Exception {
		ArrayList<DepartmentVO> dept = deptDao.searchAlldepartments();
		
		return dept;
	}
}
