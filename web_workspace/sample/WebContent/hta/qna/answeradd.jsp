<%@page import="kr.co.hta.qna.vo.Question"%>
<%@page import="kr.co.hta.qna.vo.Answer"%>
<%@page import="kr.co.hta.qna.dao.QuestionAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	

	int pno = Integer.parseInt(request.getParameter("pno"));
	int questionNo = Integer.parseInt(request.getParameter("ques_no"));
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	
	Answer answer = new Answer();
	answer.setWriter(writer);
	answer.setContents(contents);
	answer.setQuestionNo(questionNo);
	
	QuestionAnswerDao qnaDao = new QuestionAnswerDao();
	qnaDao.insertAnswer(answer);
	
	Question question = qnaDao.getQuestionByNo(questionNo);
	question.setStatus("답변완료");
	qnaDao.updateQuestion(question);
	
	response.sendRedirect("detail.jsp?no=" + questionNo + "&pno=" + pno);
%>