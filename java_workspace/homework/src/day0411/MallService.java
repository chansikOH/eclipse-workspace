package day0411;

import java.util.ArrayList;

public class MallService {
	
	CategoryDAO catDao = new CategoryDAO();
	ProductDAO proDao = new ProductDAO();
	
	public void addCategory(CategoryVO cat) throws Exception{		
		catDao.addCategory(cat);
	}
	
	public ArrayList<CategoryVO> searchAllCategories() throws Exception {
		ArrayList<CategoryVO> cat = catDao.searchAllCategories();
		
		return cat;
	}
	
	public void addProduct(ProductVO pro) throws Exception {
		proDao.addProduct(pro);
	}
	
	public ArrayList<ProductVO> searchAllProducts() throws Exception {
		ArrayList<ProductVO> pro = proDao.searchAllProducts();
		
		return pro;
	}
	
	public ArrayList<ProductVO> searchProductsByCategory(String category) throws Exception {
		ArrayList<ProductVO> pro = proDao.searchProductByCategory(category);
		
		return pro;
	}
	
	public ProductVO getProductByNo (int productNo) throws Exception {
		ProductVO pro = proDao.getProductByNo(productNo);
		
		if (pro == null) {
			throw new Exception("[" + productNo + "]에 해당하는 상품정보가 존재하지 않습니다.");
		}
		
		return pro;
	}
	
	public void deleteProductByNo(int productNo) throws Exception {
		ProductVO pro = proDao.getProductByNo(productNo);
		
		if (pro == null) {
			throw new Exception("[" + productNo + "]에 해당하는 상품정보가 존재하지 않습니다.");
		}
		
		proDao.deleteProductByNo(productNo);
	}
}
