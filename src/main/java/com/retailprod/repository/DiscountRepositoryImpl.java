package com.retailprod.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

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
		
		Properties properties = new Properties();
		
		InputStream fin;
		try {
			fin = new FileInputStream("src/main/resources/application.properties");
			properties.load(fin);
		} catch (IOException e) {
			
			log.info("context", e);

		}

		
		
		String resourceUrl= properties.getProperty("URL");
		
		ResponseEntity<Category> response
		  = restTemplate.exchange(
				    resourceUrl ,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<Category>(){});
		
		if(response.getStatusCode().is2xxSuccessful())
		{
			log.info("Yayyyy!!! get products from api {}",response.getBody().getProducts());
			
		return response.getBody().getProducts();
	}
		else {
			return Collections.emptyList();

		}
	}
	
	
	

}
