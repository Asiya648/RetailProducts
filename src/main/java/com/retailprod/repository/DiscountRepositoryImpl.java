package com.retailprod.repository;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.retailprod.domain.Category;
import com.retailprod.domain.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DiscountRepositoryImpl implements DiscountRepository {
	

	/**
	 * get products from services by category id
	 * 
	 * @param Integer categoryId
	 */
	@Override
	public List<Product> getDiscountedProducts(Integer categoryId) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String resourceUrl = "https://jl-nonprod-syst.apigee.net/v1/categories/"+categoryId+"/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
		
		ResponseEntity<Category> response
		  = restTemplate.exchange(
				    resourceUrl ,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<Category>(){});
		
		if(response.getStatusCode().is2xxSuccessful())
			log.info("Yayyyy!!! get products from api {}",response.getBody().getProducts());
		
		
		return response.getBody().getProducts();
	}
	
	
	

}
