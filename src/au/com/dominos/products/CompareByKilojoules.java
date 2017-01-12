package au.com.dominos.products;

import au.com.dominos.strategies.ICompareStrategy;

public class CompareByKilojoules implements ICompareStrategy {
	
	private int productKilojoules;

	public CompareByKilojoules(int productKilojoules) {
		this.productKilojoules = productKilojoules;
	}
	
	@Override
	public boolean CompareProduct(Product product) {
		return product.getKilojoules() == productKilojoules;
	}

}
