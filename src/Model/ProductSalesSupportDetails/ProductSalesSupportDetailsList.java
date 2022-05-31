package Model.ProductSalesSupportDetails;

import Model.Insurance.Insurance;

public interface ProductSalesSupportDetailsList {

	public boolean add(ProductSalesSupportDetails productSalesSupportDetails);

	public boolean delete(String productSalesSupportDetailsID);

	public ProductSalesSupportDetails get(String productSalesSupportDetailsID);
	
}
