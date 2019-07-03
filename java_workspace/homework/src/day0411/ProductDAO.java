package day0411;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.ConnectionUtils;

public class ProductDAO {

	public void addProduct(ProductVO pro) throws Exception{
		String sql = "insert into sample_products "
				+ "(product_no, product_name, product_maker, product_price, product_stock, product_sell, product_category) "
				+ "values (products_seq.nextval, ?, ?, ?, ?, ?, ?) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, pro.getName());
		pstmt.setString(2, pro.getMaker());
		pstmt.setInt(3, pro.getPrice());
		pstmt.setInt(4, pro.getStock());
		pstmt.setString(5, pro.getSell());
		pstmt.setString(6, pro.getCategory());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<ProductVO> searchAllProducts() throws Exception {
		ArrayList<ProductVO> pro = new ArrayList<ProductVO>();
		
		String sql =  "select "
				+ "P.product_no, "
				+ "P.product_name, "
				+ "P.product_maker, "
				+ "P.product_price, "
				+ "P.product_stock, "
				+ "P.product_sell, "
				+ "C.category_name, "
				+ "P.product_create_date "
				+ "from sample_products P, sample_categories C "
				+ "where P.product_category = C.category_code "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductVO p1 = new ProductVO();
			p1.setNo(rs.getInt("product_no"));
			p1.setName(rs.getString("product_name"));
			p1.setMaker(rs.getString("product_maker"));
			p1.setPrice(rs.getInt("product_price"));
			p1.setStock(rs.getInt("product_stock"));
			p1.setSell(rs.getString("product_sell"));
			p1.setCategory(rs.getString("category_name"));
			p1.setCreateDate(rs.getDate("product_create_date"));
			
			pro.add(p1);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return pro;
	}
	
	public ArrayList<ProductVO> searchProductByCategory (String category) throws Exception {
		ArrayList<ProductVO> pro = new ArrayList<ProductVO>();
		
		String sql =  "select "
				+ "P.product_no, "
				+ "P.product_name, "
				+ "P.product_maker, "
				+ "P.product_price, "
				+ "P.product_stock, "
				+ "P.product_sell, "
				+ "C.category_name, "
				+ "P.product_create_date "
				+ "from sample_products P, sample_categories C "
				+ "where P.product_category = C.category_code "
				+ "and C.category_name = ? "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, category);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductVO p1 = new ProductVO();
			p1.setNo(rs.getInt("product_no"));
			p1.setName(rs.getString("product_name"));
			p1.setMaker(rs.getString("product_maker"));
			p1.setPrice(rs.getInt("product_price"));
			p1.setStock(rs.getInt("product_stock"));
			p1.setSell(rs.getString("product_sell"));
			p1.setCategory(rs.getString("category_name"));
			p1.setCreateDate(rs.getDate("product_create_date"));
			
			pro.add(p1);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return pro;
	}
	
	public ProductVO getProductByNo(int productNo) throws Exception {
		ProductVO pro = null;
		
		String sql =  "select "
				+ "P.product_no, "
				+ "P.product_name, "
				+ "P.product_maker, "
				+ "P.product_price, "
				+ "P.product_stock, "
				+ "P.product_sell, "
				+ "C.category_name, "
				+ "P.product_create_date "
				+ "from sample_products P, sample_categories C "
				+ "where P.product_category = C.category_code "
				+ "and P.product_no = ? "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			pro = new ProductVO();
			
			pro.setNo(rs.getInt("product_no"));
			pro.setName(rs.getString("product_name"));
			pro.setMaker(rs.getString("product_maker"));
			pro.setPrice(rs.getInt("product_price"));
			pro.setStock(rs.getInt("product_stock"));
			pro.setSell(rs.getString("product_sell"));
			pro.setCategory(rs.getString("category_name"));
			pro.setCreateDate(rs.getDate("product_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return pro;
	}
	
	public void deleteProductByNo(int productNo) throws Exception {
		String sql = "delete from sample_products where product_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}
