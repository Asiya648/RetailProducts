package com.retailprod.services;

import java.util.List;
import java.util.Optional;

import com.retailprod.model.LabelTypeEnum;
import com.retailprod.model.ProductModel;

public interface DiscountService {
	
	
	/**
	 * @param categoryId
	 * @param priceLabelType
	 * @return List<ProductModel>
	 */
	
	List<ProductModel> getDiscountedProducts(Integer categoryId, Optional<LabelTypeEnum> priceLabelType);

}
