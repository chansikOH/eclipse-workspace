package kr.co.hta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import com.oreilly.servlet.MultipartRequest;

import kr.co.hta.dao.MemberDao;
import kr.co.hta.vo.Member;
import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class MemberController {
	
	private MemberDao memberDao = new MemberDao();

	@RequestMapping("/member/form.hta")
	public ModelAndView form(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/form.jsp");
		
		return mav;
	}
	
	@RequestMapping("/member/register.hta")
	public ModelAndView register(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();

		String saveDirectory = "C:\\projects\\web_workspace\\mvc\\WebContent\\photos";
		MultipartRequest mr = new MultipartRequest(req, saveDirectory, "utf-8");
		
		String name = mr.getParameter("username");
		String id = mr.getParameter("userid");
		String pwd = mr.getParameter("userpwd");
		String email = mr.getParameter("useremail");
		String photoName = mr.getFilesystemName("userphoto");
		
		String digestPwd = new DigestUtils(MessageDigestAlgorithms.SHA_1).digestAsHex(pwd);
		
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPwd(digestPwd);
		member.setEmail(email);
		member.setPhotoName(photoName);
		
		memberDao.insertMember(member);
		
		mav.setViewName("member/complete.jsp");
		
		return mav;
	}
	
	@RequestMapping("/member/loginform.hta")
	public ModelAndView loginform(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String result = req.getParameter("result");
		mav.addAttribute("result", result);
		
		mav.setViewName("member/loginform.jsp");
		
		return mav;
	}
	
	@RequestMapping("/member/login.hta")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String id = req.getParameter("userid");
		String pwd = req.getParameter("userpwd");
		
		Member member = memberDao.getMemberById(id);
		
		if(member == null) {
			mav.setViewName("redirect:loginform.hta?result=fail");
			return mav;
		}
		
		String digestPwd = new DigestUtils(MessageDigestAlgorithms.SHA_1).digestAsHex(pwd);
		
		if(!member.getPwd().equals(digestPwd)) {
			mav.setViewName("redirect:loginform.hta?result=fail");
			return mav;
		}
		
		HttpSession session = req.getSession();			// HttpSession 객체 얻기
		session.setAttribute("LOGINMEMBER", member);	// 세션객체에 사용자 정보 담기
		mav.setViewName("redirect:/mvc/main.hta");		// 메인페이지를 재요청하기
		
		return mav;
	}
	
	@RequestMapping("/member/logout.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = req.getSession();
		session.invalidate();
		mav.setViewName("redirect:/mvc/main.hta");
		
		return mav;
	}
	
}
