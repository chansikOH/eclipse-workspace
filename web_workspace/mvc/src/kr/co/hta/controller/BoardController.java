package kr.co.hta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hta.dao.BoardDao;
import kr.co.hta.util.CommonUtils;
import kr.co.hta.vo.Board;
import kr.co.hta.vo.Criteria;
import kr.co.hta.vo.Pagination;
import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class BoardController {

	private BoardDao boardDao = new BoardDao();

	@RequestMapping("/board/add.hta")
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		int pno = Integer.parseInt(req.getParameter("pno"));
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String contents = req.getParameter("contents");
		
		mav.addAttribute("pno", pno);
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContents(contents);
		
		boardDao.insertBoard(board);

		mav.setViewName("redirect:list.hta?pno=" + pno);

		return mav;
	}
	
	@RequestMapping("/board/form.hta")
	public ModelAndView form(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		int pno = Integer.parseInt(req.getParameter("pno"));
		mav.addAttribute("pno", pno);
		mav.setViewName("board/form.jsp");
		
		return mav;
	}
	
	@RequestMapping("/board/detail.hta")
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		String gubun = req.getParameter("gubun");
		int pno = Integer.parseInt(req.getParameter("pno"));
		int boardNo = Integer.parseInt(req.getParameter("no"));
		Board board = boardDao.getBoardByNo(boardNo);
		
		mav.addAttribute("pno", pno);
		mav.addAttribute("no", boardNo);
		mav.addAttribute("board", board);
		
		if ("detail".equals(gubun)) {
			mav.setViewName("board/detail.jsp");
		} else if ("modify".equals(gubun)) {
			mav.setViewName("board/modifyform.jsp");
		}
		
		return mav;
	}
	
	@RequestMapping("/board/list.hta")
	public ModelAndView list2(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list2.jsp");
		
		int pno = CommonUtils.stringToNumber(req.getParameter("pno"), 1);
		int size = CommonUtils.stringToNumber(req.getParameter("size"), 10);
		String sort = req.getParameter("sort");
		String opt = req.getParameter("opt");
		String keyword = req.getParameter("keyword");
		
		Criteria criteria = new Criteria();
		criteria.setSize(size);
		if (sort != null && !sort.isEmpty()) {
			criteria.setSort(sort);
		} else {
			criteria.setSort("NEW");
		}
		criteria.setBeginIndex((pno - 1)*size + 1);
		criteria.setEndIndex(pno*size);
		if(keyword != null && !keyword.isEmpty()) {
			criteria.setOption(opt);
			criteria.setKeyword(keyword);
		}		
		
		// 글 개수 조회
		int records = boardDao.getRecords(criteria);
		// 페이지번호에 해당하는 글 목록 조회
		List<Board> boards = boardDao.getBoardList(criteria);
		// 페이지 네비게이션 처리에 필요한 Pagination 객체 생성
		Pagination pagination = new Pagination(pno, size, records);
		
		mav.addAttribute("boards", boards);
		mav.addAttribute("pagination", pagination);
		
		return mav;
	}
	
	/*
	@RequestMapping("/board/list.hta")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse res) throws Exception {
				
		ModelAndView mav = new ModelAndView();	
		
		int pno = Integer.parseInt(req.getParameter("pno"));
		int begin = (pno-1)*10 +1;
		int end = pno*10;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		
		mav.addAttribute("pno", pno);
		
		List<Board> boards = boardDao.getBoardByRange(map);
		// List<Board> boards = boardDao.getAllBoards();
		mav.addAttribute("boards", boards);
		
		int totalRecordsCount = boardDao.getBoardsCount();
		int totalPageCount = (int) Math.ceil((double)totalRecordsCount/10);
		mav.addAttribute("totalPCount", totalPageCount);
		
		mav.setViewName("board/list.jsp");

		return mav;
	}
	*/
	
	@RequestMapping("/board/del.hta")
	public ModelAndView del(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int pno = Integer.parseInt(req.getParameter("pno"));
		int boardNo = Integer.parseInt(req.getParameter("no"));
		String usedYn = "N";
		
		mav.addAttribute("pno", pno);	
		
		Board board = boardDao.getBoardByNo(boardNo);
		board.setUsedYn(usedYn);
		
		boardDao.updateBoard(board);
		
		mav.setViewName("redirect:list.hta?pno=" + pno);
		
		return mav;
	}
	
	@RequestMapping("/board/likes.hta")
	public ModelAndView likes(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String gubun = req.getParameter("gubun");
		int pno = Integer.parseInt(req.getParameter("pno"));
		int boardNo = Integer.parseInt(req.getParameter("no"));
		
		mav.addAttribute("pno", pno);	
		
		Board board = boardDao.getBoardByNo(boardNo);
		board.setLikes(board.getLikes() + 1);
		
		boardDao.updateBoard(board);
		
		mav.setViewName("redirect:detail.hta?pno=" + pno + "&no=" + boardNo + "&gubun=" + gubun);
		
		return mav;
	}
	
	@RequestMapping("/board/modify.hta")
	public ModelAndView modify(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String gubun = req.getParameter("gubun");
		int pno = Integer.parseInt(req.getParameter("pno"));
		int boardNo = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String contents = req.getParameter("contents");
		
		mav.addAttribute("pno", pno);
		mav.addAttribute("no", boardNo);
		mav.addAttribute("gubun", gubun);
		
		Board board = boardDao.getBoardByNo(boardNo);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContents(contents);
		
		boardDao.updateBoard(board);
		
		mav.setViewName("redirect:detail.hta?pno=" + pno + "&no=" + boardNo + "&gubun=" + gubun);
		
		return mav;
	}
}
