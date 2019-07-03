<%@page import="kr.co.hta.qna.vo.Question"%>
<%@page import="kr.co.hta.qna.dao.QuestionAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	

	int pno = Integer.parseInt(request.getParameter("pno"));

	String gubun = request.getParameter("gubun");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	
	Question question = new Question();
	question.setGubun(gubun);
	question.setTitle(title);
	question.setWriter(writer);
	question.setContents(contents);
	
	QuestionAnswerDao qnaDao = new QuestionAnswerDao();
	qnaDao.insertQuestion(question);
	
	response.sendRedirect("list.jsp?pno=" + pno);

%>