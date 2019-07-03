package kr.co.hta.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.hta.util.IbatisUtils;
import kr.co.hta.vo.Board;
import kr.co.hta.vo.Criteria;

public class BoardDao {
	
	private SqlMapClient sqlMap = IbatisUtils.getSqlMap();

	@SuppressWarnings("unchecked")
	public List<Board> getAllBoards() throws Exception {
		return sqlMap.queryForList("getAllBoards");
	}
	
	public void insertBoard(Board board) throws Exception {
		sqlMap.insert("insertBoard", board);
	}
	
	public Board getBoardByNo(int boardNo) throws Exception {
		return (Board) sqlMap.queryForObject("getBoardByNo", boardNo);
	}
	
	public int getBoardsCount() throws Exception {
		return (int) sqlMap.queryForObject("getBoardsCount");
	}
	
	@SuppressWarnings("unchecked")
	public List<Board> getBoardByRange(Map<String, Object> map) throws Exception {
		return (List<Board>) sqlMap.queryForList("getBoardByRange", map);
	}
	
	public void updateBoard(Board board) throws Exception {
		sqlMap.update("updateBoard", board);
	}
	
	@SuppressWarnings("unchecked")
	public List<Board> getBoardList(Criteria c) throws Exception {
		return sqlMap.queryForList("getBoardList", c);
	}
	
	public int getRecords(Criteria c) throws Exception {
		return (Integer) sqlMap.queryForObject("getRecords", c);
	}
}