package model2.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 응답 컨텐츠 제작에 필요한 데이터를 생성한다.
public class SimpleModel {

	public void process(HttpServletRequest req, HttpServletResponse resp) {
		
		String username = "홍길동";
		req.setAttribute("username", username);
		
		String[] news = {"북한 핵포기 선언", "9월 트럼프 평양방문", "금강산관광 6월 재개"};
		req.setAttribute("news", news);
	}
}
