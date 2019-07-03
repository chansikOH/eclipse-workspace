<%@page import="kr.co.hta.qna.vo.Question"%>
<%@page import="kr.co.hta.qna.dao.QuestionAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	

	int questionNo = Integer.parseInt(request.getParameter("no"));
	int pno = Integer.parseInt(request.getParameter("pno"));
	
	QuestionAnswerDao qnaDao = new QuestionAnswerDao();
	Question question = qnaDao.getQuestionByNo(questionNo);
	
	question.setStatus("목록삭제");
	
	qnaDao.updateQuestion(question);
	
	response.sendRedirect("list.jsp?pno=" + pno);
%>