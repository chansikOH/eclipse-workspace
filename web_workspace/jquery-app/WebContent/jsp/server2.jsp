<%@page import="java.util.StringJoiner"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	List<String> books = Arrays.asList("여행의 이유", "천년의 질문", "아이 마음에 상처 주지 않는 습관", 
										"베르나르 베르베르의 죽음", "실현 가능하고 지속 가능한 독서교육", 
										"뉴이스트여행 포토 에세이", "추리천재 엉덩이 탐정과 카레 사건", 
										"흔한 남매", "룬의 아이들", "아주 작은 습관의 힘");

	Set<String> suggestBooks = new HashSet<>();
	Random random = new Random();
	
	while (true) {
		String title = books.get(random.nextInt(10));
		suggestBooks.add(title);
		if(suggestBooks.size() == 3) {
			break;
		}
	}
	
	StringJoiner joiner = new StringJoiner(",");
	for (String t : suggestBooks) {
		joiner.add(t);
	}
	
	out.write(joiner.toString());
%>