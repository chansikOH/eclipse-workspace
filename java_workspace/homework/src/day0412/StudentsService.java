package day0412;

import java.util.ArrayList;

public class StudentsService {

	EmployeesDAO empDao = new EmployeesDAO();
	DepartmentsDAO deptDao = new DepartmentsDAO();
	ProfessorDAO proDao = new ProfessorDAO();
	StudentsDAO stuDao = new StudentsDAO();
	CourseDAO courDao = new CourseDAO();
	
	public boolean login(String id, String password) throws Exception{
		boolean isSuccess = false;
		StudentVO stu = stuDao.getStudent(id);

		if(stu == null) {
			throw new Exception("아이디가 틀렸습니다.");
		}
		
		if(!stu.getPassword().equals(password)) {
			throw new Exception("비밀번호가 틀렸습니다.");
		}
		
		isSuccess = true;
		
		return isSuccess;
	}
	
	public ArrayList<CourseVO> searchCourseByDept(String id) throws Exception {
		ArrayList<CourseVO> cour = stuDao.searchCourseByDept(id);
		
		return cour;
	}
	
	public ArrayList<CourseRequestListVO> searchCourseReq(String id) throws Exception {
		ArrayList<CourseRequestListVO> courReq = stuDao.searchCourseReqById(id);
		
		return courReq;
	}
	
	public void requestCourse (int courseNo, String id) throws Exception {
		CourseVO cour = courDao.getCourse(courseNo);
		
		if (cour == null) {
			throw new Exception("해당 개설 과정이 없습니다.");
		}
		
		stuDao.requestCourse(courseNo, id);
	}
	
	public void deleteCourseReq (int courseNo, String id) throws Exception {
		CourseVO cour = courDao.getCourse(courseNo);
		
		if (cour == null) {
			throw new Exception("해당 개설 과정이 없습니다.");
		}
		
		stuDao.deleteCourseReq(courseNo, id);
	}
	
	public void updateStatus(String status, String id) throws Exception {
		stuDao.updateStatus(status, id);
	}
}
