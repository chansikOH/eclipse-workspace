package kr.co.hta.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/main.hta")
	public ModelAndView main(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main.jsp");
		
		return mav;
	}

	@RequestMapping("/home.hta")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("massage", "홈페이지 방문을 환영합니다.");
		mav.addAttribute("currentTime", new Date());
		
		mav.setViewName("home.jsp");
		
		return mav;
	}
}
