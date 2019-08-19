package com.retailprod.converter;

import java.util.Optional;
import java.util.Currency;
import com.retailprod.domain.Price;
import com.retailprod.domain.Product;
import com.retailprod.model.LabelTypeEnum;
import com.retailprod.model.ProductModel;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductToProductModelConverter {
	
	Currency c = Currency.getInstance("GBP"); 
	
	public ProductModel convert(Product source, Optional<LabelTypeEnum> labelType) {
		
		if(source==null)
		{
			return null;
		}

		log.info("price {}", source.getPrice());
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
		String nowNewPrice;
			nowPrice = Float.parseFloat((String)price.getNow());
			if (nowPrice <10)
			{
				nowNewPrice=c.getSymbol()+Math.round(nowPrice);
				
			}
			else
			{
				nowNewPrice=c.getSymbol()+ nowPrice;
			}
		
		return nowNewPrice;
	}
	
	
	/**
	 * price label processes
	 */
	
	private String printPriceLabel(Optional<LabelTypeEnum> labelType, Price price) {
		
		String response="";
		
		LabelTypeEnum priceLabel = labelType.map(x -> {

			return x;

		}).orElse(LabelTypeEnum.SHOWWASNOW);
		
		if(LabelTypeEnum.SHOWWASNOW == (priceLabel)) {
			
			response = "Was "+c.getSymbol()+String.valueOf(price.getWas())+", Now "+nowPrice(price);
					
		}
		else if(LabelTypeEnum.ShOWWASTHENNOW == (priceLabel)) 
		{
			if(((!(String.valueOf(price.getThen2()).isEmpty())) || (price.getThen2() != null)) && ((!(String.valueOf(price.getThen1()).isEmpty())) || (price.getThen1() != null)))
			{
				response= "Was "+c.getSymbol()+String.valueOf(price.getWas())+", Then "+c.getSymbol()+(String.valueOf(price.getThen2()))+", Now "+nowPrice(price);
				
			}
			else if(((!(String.valueOf(price.getThen2()).isEmpty())) || (price.getThen2() != null)) && ((String.valueOf(price.getThen1()).isEmpty()) || (price.getThen1() == null)))
			{
				response= "Was "+c.getSymbol()+String.valueOf(price.getWas())+", Then "+c.getSymbol()+(String.valueOf(price.getThen2()))+", Now "+nowPrice(price);
			}
			else if(((!(String.valueOf(price.getThen1()).isEmpty())) || (price.getThen1() != null)) && ((String.valueOf(price.getThen2()).isEmpty()) || (price.getThen2() == null)))
			{
				response= "Was "+c.getSymbol()+String.valueOf(price.getWas())+", Then "+c.getSymbol()+(String.valueOf(price.getThen1()))+", Now "+nowPrice(price);
			}
			else if(((String.valueOf(price.getThen1()).isEmpty()) || (price.getThen1() == null)) && ((String.valueOf(price.getThen2()).isEmpty()) || (price.getThen2() == null)))
			{
				response= "Was "+c.getSymbol()+String.valueOf(price.getWas())+", Now "+nowPrice(price);
			}
			log.info(" {}",priceLabel);
		}
		else if(LabelTypeEnum.ShOWPERCDSCOUNT == (priceLabel)) 
		{
			Float f= Float.parseFloat((String)price.getNow());
			double newValNow= f;
			double newValWas = price.getWas();
			
			double percent= calculateDiscountPersentange(newValNow,newValWas);
			response= String.format("%.0f%%",percent)+" off -"+" Now "+nowPrice(price);
			log.info(" {}",priceLabel);
		}

		
		return response;
	}
	

	
	private Double calculateDiscountPersentange(Double nowPrice, Double beforePrice) {

		return ((beforePrice-nowPrice)/beforePrice)*100;

	}
	

}
