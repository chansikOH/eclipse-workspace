package kr.co.hta.dao;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.hta.util.IbatisUtils;
import kr.co.hta.vo.Member;

public class MemberDao {

	private SqlMapClient sqlMap = IbatisUtils.getSqlMap();
	
	public void insertMember(Member member) throws Exception {
		sqlMap.insert("insertMember", member);
	}
	
	public Member getMemberById(String userId) throws Exception {
		return (Member) sqlMap.queryForObject("getMemberById", userId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Member> getAllMembers() throws Exception {
		return sqlMap.queryForList("getAllMembers");
	}
}
