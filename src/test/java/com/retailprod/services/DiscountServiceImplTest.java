package com.retailprod.services;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailprod.domain.Product;
import com.retailprod.model.ProductModel;
import com.retailprod.repository.DiscountRepository;



@RunWith(SpringRunner.class)
public class DiscountServiceImplTest {
	
	private static final Integer CATEGORY_ID = 123;
	
    @TestConfiguration
    static class DiscauntServicesImplTestContextConfiguration {

        @Bean
        public DiscountService discauntService() {
            return new DiscountServiceImpl();
        }
    }

    @Autowired
    private DiscountService discauntService;

    @MockBean
    private DiscountRepository discountRepository;

    @Before
    public void setUp() throws Exception {

        Mockito.when(discountRepository.getDiscountedProducts(CATEGORY_ID))
                .thenReturn(new ArrayList<Product>());
    }

    @Test
    public void get_productModels() {
        List<ProductModel> pms = discauntService.getDiscountedProducts(CATEGORY_ID, Optional.empty());
        assertTrue(pms.size()==0);
    }

	

}
