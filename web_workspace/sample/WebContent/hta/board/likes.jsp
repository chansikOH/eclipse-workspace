<%@page import="java.net.URLEncoder"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@page import="kr.co.hta.board.vo.Board"%>
<%@page import="kr.co.hta.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	Member member = (Member)session.getAttribute("LOGINUSER");
	if(member == null) {
		response.sendRedirect("/hta/login/loginform.jsp?result=deny&page=" + URLEncoder.encode("좋아요", "utf-8"));
		return;
	}

	int boardNo = Integer.parseInt(request.getParameter("no"));
	int pno = Integer.parseInt(request.getParameter("pno"));

	BoardDao boardDao = new BoardDao();
	Board board = boardDao.selectBoard(boardNo);
	board.setLikes(board.getLikes() + 1);
	
	boardDao.updateBoard(board);
	
	response.sendRedirect("detail.jsp?no=" + boardNo + "&pno=" + pno);
%>