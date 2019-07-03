package kr.co.hta.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.hta.qna.vo.Answer;
import kr.co.hta.qna.vo.Question;
import kr.co.hta.util.ConnectionUtils;

public class QuestionAnswerDao {

	// 모든 질문글을 불러오는 기능
	public ArrayList<Question> getAllQuestions() throws Exception {
		ArrayList<Question> questions = new ArrayList<Question>();
		
		String sql = "select * "
				+ "from hta_questions "
				+ "order by ques_no desc ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Question question = new Question();
			question.setNo(rs.getInt("ques_no"));
			question.setGubun(rs.getString("ques_gubun"));
			question.setTitle(rs.getString("ques_title"));
			question.setWriter(rs.getString("ques_writer"));
			question.setStatus(rs.getString("ques_status"));
			question.setContents(rs.getString("ques_contents"));
			question.setCreateDate(rs.getTimestamp("ques_create_date"));
			
			questions.add(question);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return questions;
	}
	
	// 질문글을 등록하는 기능
	public void insertQuestion(Question question) throws Exception {
		String sql = "insert into hta_questions(ques_no, ques_gubun, ques_title, ques_writer, ques_contents) "
				+ "values(qna_seq.nextval, ?, ?, ?, ?) ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, question.getGubun());
		pstmt.setString(2, question.getTitle());
		pstmt.setString(3, question.getWriter());
		pstmt.setString(4, question.getContents());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public Question getQuestionByNo(int questionNo) throws Exception {
		Question question = null;
		
		String sql = "select * "
				+ "from hta_questions "
				+ "where ques_no = ? ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, questionNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			question = new Question();
			question.setNo(rs.getInt("ques_no"));
			question.setGubun(rs.getString("ques_gubun"));
			question.setTitle(rs.getString("ques_title"));
			question.setWriter(rs.getString("ques_writer"));
			question.setStatus(rs.getString("ques_status"));
			question.setContents(rs.getString("ques_contents"));
			question.setCreateDate(rs.getTimestamp("ques_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return question;
	}
	
	public Answer getAnswerByQuesNo(int questionNo) throws Exception {
		Answer answer = null;
		
		String sql = "select * "
				+ "from hta_answers "
				+ "where ques_no = ? ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, questionNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			answer = new Answer();
			answer.setNo(rs.getInt("ans_no"));
			answer.setWriter(rs.getString("ans_writer"));
			answer.setContents(rs.getString("ans_contents"));
			answer.setCreateDate(rs.getTimestamp("ans_create_date"));
			answer.setQuestionNo(rs.getInt("ques_no"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return answer;
	}
	
	public void updateQuestion(Question question) throws Exception {
		String sql = "update hta_questions "
				+ "set "
				+ "		ques_gubun = ?, "
				+ "		ques_title = ?, "
				+ "		ques_writer = ?, "
				+ "		ques_status = ?, "
				+ "		ques_contents = ? "
				+ "where ques_no = ? ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, question.getGubun());
		pstmt.setString(2, question.getTitle());
		pstmt.setString(3, question.getWriter());
		pstmt.setString(4, question.getStatus());
		pstmt.setString(5, question.getContents());
		pstmt.setInt(6, question.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void insertAnswer(Answer answer) throws Exception {
		String sql = "insert into hta_answers(ans_no, ans_writer, ans_contents, ques_no) "
				+ "values(qna_seq.nextval, ?, ?, ?) ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, answer.getWriter());
		pstmt.setString(2, answer.getContents());
		pstmt.setInt(3, answer.getQuestionNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public int getQuestionCount() throws Exception {
		int totalCount = 0;
		
		String sql = "select count(*) cnt "
				+ "from hta_questions "
				+ "where ques_status <> '목록삭제' ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalCount = rs.getInt("cnt");
		
		rs.close();
		pstmt.close();
		con.close();
		
		return totalCount;
	}
	
	public ArrayList<Question> getQuestionsByRange(int begin, int end) throws Exception {
		ArrayList<Question> questions = new ArrayList<Question>();
		
		String sql = "select * "
				+ "from (select row_number() over (order by ques_no desc) row_no, "
				+ "			A.*"
				+ "		from hta_questions A "
				+ "		where ques_status <> '목록삭제') "
				+ "where row_no >= ? and row_no <= ? ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, begin);
		pstmt.setInt(2, end);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Question question = new Question();
			question.setNo(rs.getInt("ques_no"));
			question.setGubun(rs.getString("ques_gubun"));
			question.setTitle(rs.getString("ques_title"));
			question.setWriter(rs.getString("ques_writer"));
			question.setStatus(rs.getString("ques_status"));
			question.setContents(rs.getString("ques_contents"));
			question.setCreateDate(rs.getTimestamp("ques_create_date"));
			
			questions.add(question);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return questions;
	}
	
}
