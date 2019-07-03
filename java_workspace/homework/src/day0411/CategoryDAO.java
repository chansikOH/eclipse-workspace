package day0411;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.ConnectionUtils;

public class CategoryDAO {

	public void addCategory(CategoryVO cat) throws Exception {
		String sql = "insert into sample_categories "
				+ "(category_code, category_name) "
				+ "values (?, ?)";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cat.getCode());
		pstmt.setString(2, cat.getName());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<CategoryVO> searchAllCategories() throws Exception {
		ArrayList<CategoryVO> cat = new ArrayList<CategoryVO>();
		
		String sql = "select "
				+ "category_code, "
				+ "category_name "
				+ "from sample_categories "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String code = rs.getString("category_code");
			String name = rs.getString("category_name");
			
			CategoryVO c1 = new CategoryVO();
			c1.setCode(code);
			c1.setName(name);
			
			cat.add(c1);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return cat;
	}
}
