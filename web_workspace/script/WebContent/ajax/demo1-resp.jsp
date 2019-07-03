<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String nc = request.getParameter("nc");
	
	if("k".equals(nc)) {
		out.write("김치찌개, 된장찌개, 순대국, 부대찌개, 부침개, 비빔밥");
	} else if ("c".equals(nc)) {
		out.write("짜장면, 짬뽕, 유산슬, 탕수육, 라조기, 해파리냉채, 불도장");
	} else if ("j".equals(nc)) {
		out.write("스시, 우동, 라멘, 벤또, 돈까스, 규동, 타코야끼");
	}
%>