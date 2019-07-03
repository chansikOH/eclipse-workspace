package demo.store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class StoreServer {

	public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(444);
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Item> carts = new ArrayList<Item>();
		
		User session = new User();
		
		products.add(new Product(100, "아이폰XS", "140만원", 1000));
		products.add(new Product(200, "갤럭시S10", "120만원", 1000));
		products.add(new Product(300, "LG그램", "200만원", 1000));
		products.add(new Product(400, "레노버X280", "260만원", 1000));
		products.add(new Product(500, "갤럭시워치", "40만원", 1000));
		products.add(new Product(600, "애플워치", "50만원", 1000));
		
		System.out.println("서버가 시작되었습니다...");
		
		Socket socket = server.accept();
		while (true) {
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String text = in.readLine();
			
			String[] values = text.split(":");
			if("add_user".equals(values[0])) {
				System.out.println(text);
				boolean isUser = false;
				for(User findUser : users) {
					if (findUser.getId().equals(values[1])) {
						isUser = true;
						break;
					}
				}
				
				if (isUser) {
					out.println("res_add_user:fail:이미 존재하는 아이디 입니다.");					
				} else {
					User user = new User(values[1], values[3], values[2]);
					users.add(user);
					
					out.println("res_add_user:success");
				}
				
			} else if("login_user".equals(values[0])) {
				System.out.println(text);
				boolean isUser = false;
				for (User findUser : users) {
					if (findUser.getId().equals(values[1]) && findUser.getPassword().equals(values[2])) {
						session = findUser;
						isUser = true;
						break;
					}
				}
				
				if(!isUser) {
					out.println("res_login_user:fail:입력정보가 틀렸습니다.");
				} else {
					out.println("res_login_user:success:로그인 되었습니다.");
				}
			
			} else if("view_products".equals(values[0])) {
				System.out.println(text);
			
				String message = "res_view_products";
				for(Product product : products) {
					int no = product.getNo();
					String name = product.getName();
					String price = product.getPrice();
					message += (":" + String.valueOf(no) + "," + name + "," + price);
				}
				
				out.println(message);
				
			} else if("detail_product".equals(values[0])) {
				System.out.println(text);
				boolean isProduct = false;
				String message = "res_detail_product";
				
				for(Product product : products) {
					if(product.getNo() == Integer.parseInt(values[1])) {
						int no = product.getNo();
						String name = product.getName();
						String price = product.getPrice();
						message += (":" + String.valueOf(no) + "," + name + "," + price);
						isProduct = true;
						break;
					}
				}
				if (!isProduct) {
					out.println("res_detail_product:fail:상품정보가 없습니다.");
				} else {
					out.println(message);
				}
								
			} else if("view_cart".equals(values[0])) {
				System.out.println(text);
				
				boolean isItem = false;
				for(Item cart : carts) {
					if (cart != null) {
						isItem = true;
						break;
					}
				}
				
				if(!isItem) {
					out.println("res_view_cart:fail");
				} else {
					String message = "res_view_cart";
					
					for(Item cart : carts) {
						if(session.getId().equals(cart.getUser().getId())) {
							int no = cart.getProduct().getNo();
							String name = cart.getProduct().getName();
							String price = cart.getProduct().getPrice();
							String amount = String.valueOf(cart.getAmount());
							message += (":" + String.valueOf(no) + "," + name + "," + price + "," + amount);
						}
					}
					out.println(message);
				}
				
			} else if("add_cart".equals(values[0])) {
				System.out.println(text);
				boolean isCart = false;
				for (Item cart : carts) {
					if(cart.getProduct().getNo() == Integer.parseInt(values[1])) {
						cart.setAmount(cart.getAmount() + Integer.parseInt(values[2]));
						out.println("res_add_cart:success:이미 장바구니에 존재하는 상품입니다. 수량을 추가합니다.");
						isCart = true;
						break;
					}
				}
				
				if(!isCart) {
					Item cart = new Item();
					Product pro = new Product();
					for(Product product : products) {
						if(product.getNo() == Integer.parseInt(values[1])) {
							pro = product;
							break;
						}
					}
					cart.setProduct(pro);
					cart.setAmount(Integer.parseInt(values[2]));
					cart.setUser(session);
					
					carts.add(cart);
					
					out.println("res_add_cart:success:상품을 장바구니에 담았습니다.");
				}
				
			} else if("view_user".equals(values[0])) {
				System.out.println(text);
				
				out.println("res_view_user:" + session.getId() + "," + session.getName());
				
			} else if("change_pwd".equals(values[0])) {
				System.out.println(text);
				
				boolean isId = false;
				if (session.getPassword().equals(values[1])) {
					isId = true;
				}
				
				if(!isId) {
					out.println("res_change_pwd:fail:현재 비밀번호와 맞지 않습니다.");
				} else {
					for(User user : users) {
						if(user.getId().equals(session.getId())) {
							user.setPassword(values[2]);
							break;
						}
					}
					out.println("res_change_pwd:success:정상적으로 변경되었습니다.");
				}
				
			} else if("logout_user".equals(values[0])) {
				System.out.println(text);
				session = null;
				out.println("logout:success");
			}
		}
	}
}
