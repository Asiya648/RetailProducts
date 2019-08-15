package com.retailprod.repository;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailprod.domain.Category;
import com.retailprod.domain.Product;
import com.retailprod.services.DiscountService;
import com.retailprod.services.DiscountServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@RestClientTest(DiscountRepositoryImpl.class)
public class DiscountRepositoryImplTest {
 
    @Test
    public void when_callingapi_thenClientMakesCorrectCall() throws Exception {
 
    	// 
    	RestTemplate restTemplate = new RestTemplate();
    
    	final String baseUrl = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    assertTrue(200 == result.getStatusCodeValue());
	    assertTrue(result.getBody().contains("products"));
    }
	
	
	

}
