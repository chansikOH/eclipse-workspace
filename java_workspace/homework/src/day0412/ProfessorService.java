package day0412;

public class ProfessorService {

	EmployeesDAO empDao = new EmployeesDAO();
	DepartmentsDAO deptDao = new DepartmentsDAO();
	ProfessorDAO proDao = new ProfessorDAO();
	StudentsDAO stuDao = new StudentsDAO();
	CourseDAO courDao = new CourseDAO();
	
	public boolean login(String id, String password) throws Exception{
		boolean isSuccess = false;
		ProfessorVO prof = proDao.getProfessor(id);

		if(prof == null) {
			throw new Exception("아이디가 틀렸습니다.");
		}
		
		if(!prof.getPassword().equals(password)) {
			throw new Exception("비밀번호가 틀렸습니다.");
		}
		
		isSuccess = true;
		
		return isSuccess;
	}
}
