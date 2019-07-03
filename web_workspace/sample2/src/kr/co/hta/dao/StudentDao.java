package kr.co.hta.dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.hta.utils.IbatisUtils;
import kr.co.hta.vo.Student;

public class StudentDao {

	private SqlMapClient sqlMap = IbatisUtils.getSqlMap();
	
	public void insertStudent(Student student) throws Exception {
		sqlMap.insert("insertStudent", student);
	}
	
	public Student getStudentById(String studentId) throws Exception {
		return (Student) sqlMap.queryForObject("getStudentById", studentId);
	}
	
	public void updateStudent(Student student) throws Exception {
		sqlMap.update("updateStudent", student);
	}
}
