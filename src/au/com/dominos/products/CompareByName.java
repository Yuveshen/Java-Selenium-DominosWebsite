package au.com.dominos.products;

import au.com.dominos.strategies.ICompareStrategy;

public class CompareByName implements ICompareStrategy {
	
	private String productName;

	public CompareByName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public boolean CompareProduct(Product product) {
		productName = productName.toUpperCase();
		return product.getName().equals(productName);
	}
}
