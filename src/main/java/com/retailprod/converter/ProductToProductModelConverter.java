package com.retailprod.converter;

import java.util.Optional;
import java.util.Currency;


import org.springframework.beans.factory.annotation.Autowired;

import com.retailprod.domain.Price;
import com.retailprod.domain.Product;
import com.retailprod.model.LabelTypeEnum;
import com.retailprod.model.ProductModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductToProductModelConverter {
	
	@Autowired
	private ColorSwatchToColorSwatchModelConverter colorSwatchConverter;
	
	Currency c = Currency.getInstance("GBP"); 
	
	public ProductModel convert(Product source, LabelTypeEnum labelType) {
		
		if(source==null)
		{
			return null;
		}

		String priceLabel = printPriceLabel(labelType, source.getPrice());
		
		log.info("product id {}", source.getProductId());
		
		
		ProductModel target = new ProductModel();
		
		target.setId(source.getProductId());
		target.setTitle(source.getTitle());
		target.setPriceLabel(priceLabel);
		target.setNowPrice(nowPrice(source.getPrice()));
						
		log.info("product {}", target);
		
		return target;
		
	}
	
	/**
	 * @param price Price.class
	 * @return String
	 */
	private String nowPrice(Price price) {
		Float nowPrice;
		
		try {
			nowPrice = Float.parseFloat((String)price.getnow());
		}catch (Exception e) {
			
			
		}	
		return nowPrice <10 ? c.getSymbol()+Math.round(nowPrice) : c.getSymbol()+ nowPrice ;
	}
	
	
	/**
	 * price label processes
	 */
	
	private String printPriceLabel(LabelTypeEnum labelType, Price price) {
		
		String response="";
		
		LabelTypeEnum priceLabel = labelType.orElse(LabelTypeEnum.ShowWasNow);
		
		
		if(LabelTypeEnum.ShowWasNow == (priceLabel)) {
			
			response = price.getWas().map( x -> {
				return "Was " +c.getSymbol()+x+", now "+nowPrice(price);
			}).orElse("Was "+nowPrice(price)+", now "+nowPrice(price));
		
		}
		else if(LabelTypeEnum.ShowWasThenNow == (priceLabel)) 
		{
			if(!(Float.toString(price.getthen2())).isEmpty())
			{
				response= "Was"+c.getSymbol()+Float.toString(price.getWas())+", then"+(Float.toString(price.getthen2()))+", now"+nowPrice(price);
			}
			else if(!(Float.toString(price.getthen1())).isEmpty())
			{
				response= "Was"+c.getSymbol()+Float.toString(price.getWas())+", then"+(Float.toString(price.getthen1()))+", now"+nowPrice(price);
			}
			else if(((Float.toString(price.getthen2())).isEmpty()) && (!(Float.toString(price.getthen1())).isEmpty()))
			{
				response= "Was"+c.getSymbol()+Float.toString(price.getWas())+", then"+(Float.toString(price.getthen1()))+", now"+nowPrice(price);
			}
			log.info(" {}",priceLabel);
		}
		else if(LabelTypeEnum.ShowPercDscount == (priceLabel)) 
		{
			Float percent= ((Float.parseFloat((String)price.getnow())-price.getwas())/price.getwas())*100;
			response= String.format("%.0f%%", percent);
			log.info(" {}",priceLabel);
		}

		
		return response;
	}
	

	
	
	

}
