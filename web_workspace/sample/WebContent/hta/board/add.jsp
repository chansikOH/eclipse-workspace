<%@page import="java.net.URLEncoder"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@page import="kr.co.hta.board.dao.BoardDao"%>
<%@page import="kr.co.hta.board.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청객체에 문자변환방식을 지정한다.
	request.setCharacterEncoding("utf-8");		// getParameter 메소드가 실행되기 전에 실행되어야 한다.

	Member member = (Member) session.getAttribute("LOGINUSER");
	if(member == null) {
		response.sendRedirect("/hta/login/loginform.jsp?result=deny&page=" + URLEncoder.encode("글등록", "utf-8"));
		return;
	}
	
	// 요청객체에서 요청 마라미터 값 꺼내기
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	
	// VO객체 생성
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(member.getName());
	board.setContents(contents);
	
	// Dao에 VO객체를 전달해서 저장하게 한다.
	BoardDao boardDao = new BoardDao();
	boardDao.insertBoard(board);
	
	// 브라우저에게 재요청할 URL을 응답으로 보낸다.
	response.sendRedirect("list.jsp");
%>