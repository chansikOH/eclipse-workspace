package day0418.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import day0418.vo.Customer;
import day0418.vo.Goods;
import day0418.vo.Order;
import day0418.vo.OrderItem;
import db.utils.ConnectionUtils;

public class OrderDao {

	public int getOrderNo() throws Exception {
		int orderNo = 0;
		
		String sql = "select order_seq.nextval as seq "
				+ "from dual ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			orderNo = rs.getInt("seq");
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return orderNo;
	}
	
	public void insertOrder(Order order) throws Exception {
		String sql = "insert into tb_orders "
				+ "values (?, ?, '배송 준비중', 'N', sysdate) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order.getNo());
		pstmt.setInt(2, order.getCustomer().getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void insertOrderItem(OrderItem orderItem) throws Exception {
		String sql = "insert into tb_order_items "
				+ "values (order_item_seq.nextval, ?, ?, ?) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderItem.getGoods().getNo());
		pstmt.setInt(2, orderItem.getAmount());
		pstmt.setInt(3, orderItem.getOrder().getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public Order getOrderByOrderNo(int orderNo) throws Exception {
		Order order = null;
		
		String sql = "select order_no, customer_no, order_state, order_cancel_yn, order_create_date "
				+ "from tb_orders "
				+ "where order_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			order = new Order();
			order.setNo(rs.getInt("order_no"));
			
			Customer customer = new Customer();
			customer.setNo(rs.getInt("customer_no"));
			order.setCustomer(customer);
			
			order.setState(rs.getString("order_state"));
			order.setCancel(rs.getString("order_cancel_yn"));
			order.setCreateDate(rs.getDate("order_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return order;
	}
	
	public void updateOrder(Order order) throws Exception {
		String sql = "update tb_orders "
				+ "set "
				+ "		customer_no = ?, "
				+ "		order_state = ?, "
				+ "		order_cancel_yn = ?, "
				+ "		order_create_date = ? "
				+ "where order_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order.getCustomer().getNo());
		pstmt.setString(2, order.getState());
		pstmt.setString(3, order.getCancel());
		pstmt.setDate(4, order.getCreateDate());
		pstmt.setInt(5, order.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<OrderItem> getOrderItemByOrderNo(int orderNo) throws Exception {
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		String sql = "select order_item_no, product_no, order_item_amount, order_no "
				+ "from tb_order_items "
				+ "where order_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setNo(rs.getInt("order_item_no"));
			
			Goods goods = new Goods();
			goods.setNo(rs.getInt("product_no"));
			orderItem.setGoods(goods);
			
			Order order = new Order();
			order.setNo(rs.getInt("order_no"));
			orderItem.setOrder(order);
			
			orderItem.setAmount(rs.getInt("order_item_amount"));
			
			orderItems.add(orderItem);
		}
		
		rs.close();
		pstmt.close();
		con.close();
				
		return orderItems;
	}
	
	public ArrayList<OrderItem> getAllOrderItemListByCustomer(Customer customer, String cancel) throws Exception {
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		String sql = "select OI.order_item_no, OI.product_no, OI.order_item_amount, OI.order_no "
				+ "from tb_order_items OI, tb_orders O "
				+ "where OI.order_no = O.order_no "
				+ "and O.customer_no = ? "
				+ "and O.order_cancel_yn = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customer.getNo());
		pstmt.setString(2, cancel);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setNo(rs.getInt("order_item_no"));
			orderItem.setAmount(rs.getInt("order_item_amount"));
			
			Goods goods = new Goods();
			goods.setNo(rs.getInt("product_no"));
			orderItem.setGoods(goods);
			
			Order order = new Order();
			order.setNo(rs.getInt("order_no"));
			orderItem.setOrder(order);
			
			orderItems.add(orderItem);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return orderItems;
	}
	
}
