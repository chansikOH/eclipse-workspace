package day0418.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import day0418.vo.Category;
import db.utils.ConnectionUtils;

public class CategoryDao {

	// 최상위 카테고리정보 조회기능
	public ArrayList<Category> getAllParentCategoryList() throws Exception {
		ArrayList<Category> categories = new ArrayList<Category>();
		
		String sql = "select category_no, category_name "
				+ "from tb_categories "
				+ "where parent_category_no is null ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Category category = new Category();
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			
			categories.add(category);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return categories;
	}

	// 하위 카테고리정보 조회기능
	public ArrayList<Category> getChildCategoryList(int parentCategoryNo) throws Exception {
		ArrayList<Category> categories = new ArrayList<Category>();
		
		String sql = "select level, category_no, category_name, parent_category_no "
				+ "from tb_categories "
				+ "start with category_no = ? "
				+ "connect by prior category_no = parent_category_no ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, parentCategoryNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Category category = new Category();
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			category.setParentNo(rs.getInt("parent_category_no"));
			
			categories.add(category);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return categories;
	}
	
	// 카테고리 넘버로 카테고리를 반환하는 기능
	public Category getCategoryByNo(int categoryNo) throws Exception {
		Category category = null;
		
		String sql = "select category_no, category_name, parent_category_no "
				+ "from tb_categories "
				+ "where category_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, categoryNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			category = new Category();
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			category.setParentNo(rs.getInt("parent_category_no"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return category;
	}
}
