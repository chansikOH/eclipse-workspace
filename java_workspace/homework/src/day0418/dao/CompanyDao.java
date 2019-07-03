package day0418.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day0418.vo.Company;
import db.utils.ConnectionUtils;

public class CompanyDao {

	public Company getCompanyByNo(int companyNo) throws Exception {
		Company company = null;
		
		String sql = "select company_no, company_name, company_tel, company_create_date "
				+ "from tb_companies "
				+ "where company_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, companyNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			company = new Company();
			company.setNo(rs.getInt("company_no"));
			company.setName(rs.getString("company_name"));
			company.setTel(rs.getString("company_tel"));
			company.setCreateDate(rs.getDate("company_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return company;
	}
}
