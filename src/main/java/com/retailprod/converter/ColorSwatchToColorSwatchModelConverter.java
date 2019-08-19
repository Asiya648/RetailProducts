package com.retailprod.converter;

import java.util.Enumeration;
import java.util.Hashtable;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;
import com.retailprod.domain.ColorSwatch;
import com.retailprod.model.ColorSwatchModel;

@Component
public class ColorSwatchToColorSwatchModelConverter implements Converter<ColorSwatch, ColorSwatchModel> {

	@Override
	public ColorSwatchModel convert(ColorSwatch source) {
		
		if(source==null)
		{
			return null;
		}
		ColorSwatchModel target = new ColorSwatchModel();
		
		target.setColor(source.getColor());
		target.setSkuid(source.getSkuId());
		target.setRgbColor(stringToColor(source.getRgbColor()));
		
		return target;
	}

	static String stringToColor(String str) {
		
		 String value;
		 
		 
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
         
		  if (str == null) {
		      return null;
		  }
		  hashtable.put("Black", "000000");
		  hashtable.put("Red", "FF0000");
		  hashtable.put("White", "FFFFFF");
		  hashtable.put("Blue", "0000FF");
		  hashtable.put("Green", "00FF00");
		  
		  value= hashtable.get(str);
		   
		  return value;
}
}
