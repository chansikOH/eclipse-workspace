package kr.co.hta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hta.dao.MemberDao;
import kr.co.hta.vo.Member;
import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class AjaxController {

	MemberDao memberDao = new MemberDao();
	
	@RequestMapping("/admin/members.hta")
	public ModelAndView members(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<Member> members = memberDao.getAllMembers();
		mav.addAttribute("members", members);
		
		mav.setViewName("admin/members.jsp");
		return mav;
	}
	
	@RequestMapping("/admin/memberdetail.hta")
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String memberId = req.getParameter("memid");
		Member member = memberDao.getMemberById(memberId);
		
		mav.addAttribute("member", member);
		mav.setView(new JSONView());
		
		return mav;
	}
}
