package day0418.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import day0418.vo.Category;
import day0418.vo.Company;
import day0418.vo.Goods;
import db.utils.ConnectionUtils;

public class GoodsDao {

	public ArrayList<Goods> getAllGoods () throws Exception {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		
		String sql = "select G.product_no, G.product_name, G.product_price, G.product_stock, "
				+ "			Cat.category_no, Cat.category_name, Com.company_no, Com.company_name "
				+ "from tb_goods G, tb_companies Com, tb_categories Cat "
				+ "where G.company_no = Com.company_no "
				+ "			and G.category_no = Cat.category_no "
				+ "			and G.product_sell_yn = 'Y' "
				+ "order by G.product_no desc ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Goods goods = new Goods();
			goods.setNo(rs.getInt("product_no"));
			goods.setName(rs.getString("product_name"));
			goods.setPrice(rs.getInt("product_price"));
			goods.setStock(rs.getInt("product_stock"));
			
			Category category = new Category();
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			goods.setCategory(category);
			
			Company company = new Company();
			company.setNo(rs.getInt("company_no"));
			company.setName(rs.getString("company_name"));
			goods.setCompany(company);
			
			goodsList.add(goods);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return goodsList;
	}
	
	public void updateGoods(Goods goods) throws Exception {
		String sql = "update tb_goods "
				+ "set "
				+ "		product_name = ?, "
				+ "		company_no = ?, "
				+ "		product_price = ?, "
				+ "		product_stock = ?, "
				+ "		product_image_name = ?, "
				+ "		product_sell_yn = ?, "
				+ "		product_likes = ?, "
				+ "		product_create_date = ?, "
				+ "		category_no = ? "
				+ "where product_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		Goods g = getGoodsByProductNo(goods.getNo());
		
		pstmt.setString(1, g.getName());
		pstmt.setInt(2, g.getCompany().getNo());
		pstmt.setInt(3, g.getPrice());
		pstmt.setInt(4, goods.getStock());
		pstmt.setString(5, g.getImageName());
		pstmt.setString(6, g.getSell());
		pstmt.setInt(7, g.getLikes());
		pstmt.setDate(8, g.getCreateDate());
		pstmt.setInt(9, g.getCategory().getNo());
		pstmt.setInt(10, g.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public Goods getGoodsByProductNo(int productNo) throws Exception {
		Goods goods = null;
		
		String sql = "select "
				+ "product_no, "
				+ "product_name, "
				+ "company_no, "
				+ "product_price, "
				+ "product_stock, "
				+ "nvl(product_image_name, '없음') image_name, "
				+ "product_sell_yn, "
				+ "product_likes, "
				+ "product_create_date, "
				+ "category_no "
				+ "from tb_goods "
				+ "where product_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			goods = new Goods();
			goods.setNo(rs.getInt("product_no"));
			goods.setName(rs.getString("product_name"));
			
			Company company = new Company();
			company.setNo(rs.getInt("company_no"));
			goods.setCompany(company);
			
			goods.setPrice(rs.getInt("product_price"));
			goods.setStock(rs.getInt("product_stock"));
			goods.setImageName(rs.getString("Image_name"));
			goods.setSell(rs.getString("product_sell_yn"));
			goods.setLikes(rs.getInt("product_likes"));
			goods.setCreateDate(rs.getDate("product_create_date"));
			
			Category category = new Category();
			category.setNo(rs.getInt("category_no"));
			goods.setCategory(category);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return goods;
	}
}
