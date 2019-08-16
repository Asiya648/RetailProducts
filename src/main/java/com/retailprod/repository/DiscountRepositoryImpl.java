package com.retailprod.repository;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
		
		InputStream fin = new FileInputStream("src/main/resources/application.properties");

		properties.load(fin);
		
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
			final String EMPTY_STRING = "";
			List<Character> chars = convertStringToCharList(EMPTY_STRING);
			
			
			 
		}
	}
	
	public static List<Character> 
    convertStringToCharList(String str) 
    { 
  
        // Create an empty List of character 
        List<Character> chars = new ArrayList<>(); 
  
        // For each character in the String 
        // add it to the List 
        for (char ch : str.toCharArray()) { 
  
            chars.add(ch); 
        } 
  
        // return the List 
        return chars; 
    } 
	

}
