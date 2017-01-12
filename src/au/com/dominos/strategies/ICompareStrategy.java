package au.com.dominos.strategies;

import au.com.dominos.products.Product;

public interface ICompareStrategy {

	abstract boolean CompareProduct(Product product);
}
