package com.retailprod.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailprod.converter.ProductToProductModelConverter;
import com.retailprod.model.LabelTypeEnum;
import com.retailprod.model.ProductModel;
import com.retailprod.repository.DiscountRepository;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	private DiscountRepository discountRepository;

	@Override
	public List<ProductModel> getDiscountedProducts(Integer categoryId, Optional<LabelTypeEnum> priceLabelType) {
		
		
		// converter
		ProductToProductModelConverter productConverter = new ProductToProductModelConverter();
		
		// convert product to productModel and map elements to productModel list
		return discountRepository.getDiscountedProducts(categoryId).stream().map(product -> productConverter.convert(product, priceLabelType)
						).collect(Collectors.toList());
		
		
	}

	

}
