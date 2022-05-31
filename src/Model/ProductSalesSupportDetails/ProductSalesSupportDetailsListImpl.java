package Model.ProductSalesSupportDetails;

import java.util.ArrayList;

public class ProductSalesSupportDetailsListImpl implements ProductSalesSupportDetailsList {

	private ArrayList<ProductSalesSupportDetails> productSalesSupportDetailsList;
	public ProductSalesSupportDetails m_ProductSalesSupportDetails;
	
	public ProductSalesSupportDetailsListImpl() {
		productSalesSupportDetailsList = new ArrayList<ProductSalesSupportDetails>();
	}

	public void finalize() throws Throwable {
		
	}
	
	
	public boolean add(ProductSalesSupportDetails productSalesSupportDetails) {
		return false;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public boolean delete(String productSalesSupportDetailsID) {
		return false;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public ProductSalesSupportDetails get(String productSalesSupportDetailsID) {
		return null;
	}
	
	public int indexOf(String productSalesSupportDetailsID) {
		return 0;
	}
	
}
