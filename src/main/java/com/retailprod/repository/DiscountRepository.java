package com.retailprod.repository;

import java.util.List;

import com.retailprod.domain.Product;

public interface DiscountRepository {
	
	List<Product> getDiscountedProducts(Integer categoryId);

}
