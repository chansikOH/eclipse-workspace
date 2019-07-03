package model2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.model.SimpleModel;

@WebServlet(urlPatterns="/home.do")
public class SimpleController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 모델 실행
		SimpleModel model = new SimpleModel();
		model.process(req, resp);
		
		// 뷰로 이동
		req.getRequestDispatcher("WEB-INF/views/view.jsp").forward(req, resp);
	}
}
