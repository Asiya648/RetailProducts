package com.retailprod.converter;

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
		  String color = null;

		  if (str == null) {
		      return null;
		  }
		  else if (str.equalsIgnoreCase("Black"))
		    color = "000000";
		  else if(str.equalsIgnoreCase("Red"))
		    color = "FF0000";
		  else if(str.equalsIgnoreCase("White"))
		    color = "FFFFFF";
		  else if(str.equalsIgnoreCase("Blue"))
		    color = "0000FF";
		  else if(str.equalsIgnoreCase("Green"))
		    color = "00FF00";
		  
           return color;
}
}
