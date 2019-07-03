package kr.co.hta.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/greeting.hta")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// setconentType("컨텐츠타입")
		// 응답컨텐츠의 타입을 응답메세지에 설정하는 메소드
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("Hello!");
		
		//동적 html 컨텐츠를 응답으로 내려보내기
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>환영 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>환영합니다.</h1>");
		
		Date now = new Date();
		
		pw.println("<p>현재시간 : "+now+"</p>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
}
