package kr.co.hta.course.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.hta.course.vo.Comment;
import kr.co.hta.course.vo.Course;
import kr.co.hta.course.vo.Registration;
import kr.co.hta.course.vo.RegistrationDetail;
import kr.co.hta.util.IbatisUtils;

public class CourseDao {

	private SqlMapClient sqlMap = IbatisUtils.getSqlMap();
	
	public void insertCourse(Course course) throws Exception {
		sqlMap.insert("insertCourse", course);
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getAllCourses() throws Exception {
		return (List<Course>) sqlMap.queryForList("getAllCourses");
	}
	
	public Course getCourseByNo(int courseNo) throws Exception {
		return (Course) sqlMap.queryForObject("getCourseByNo", courseNo);
	}
	
	public void updateCourse(Course course)	throws Exception {
		sqlMap.update("updateCourse", course);
	}
	
	public int getRegCountByCourseNo(int courseNo) throws Exception {
		return (int) sqlMap.queryForObject("getRegCountByCourseNo", courseNo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getAvailableCourses() throws Exception {
		return (List<Course>) sqlMap.queryForList("getAvailableCourses");
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsByCourseNo(int courseNo) throws Exception {
		return (List<Comment>) sqlMap.queryForList("getCommentsByCourseNo", courseNo);
	}
	
	public void insertComment(Comment comment) throws Exception {
		sqlMap.insert("insertComment", comment);
	}
	
	public void insertRegistration(Registration registration) throws Exception {
		sqlMap.insert("insertRegistration", registration);
	}
	
	@SuppressWarnings("unchecked")
	public List<RegistrationDetail> getRegistrationDetail(String memberId) throws Exception {
		return (List<RegistrationDetail>) sqlMap.queryForList("getRegistrationDetail", memberId);
	}
	
	public Registration getRegByCourseNoAndMemberId(Map<String, Object> searchMap) throws Exception {
		return (Registration) sqlMap.queryForObject("getRegByCourseNoAndMemberId", searchMap);
	}
}
