package day0412;

import java.util.ArrayList;

public class CourseService {
	
	CourseDAO courDao = new CourseDAO();

	public ArrayList<CourseVO> searchAllcourses() throws Exception {
		ArrayList<CourseVO> cour = courDao.searchAllCourse();
		
		return cour;
	}
}
