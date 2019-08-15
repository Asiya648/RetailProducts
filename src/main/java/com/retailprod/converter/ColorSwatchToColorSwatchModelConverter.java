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
			return null;
		
		ColorSwatchModel target = new ColorSwatchModel();
		
		target.setColor(source.getColor());
		target.setSkuid(source.getSkuId());
		target.setRgbColor(source.getBasicColor());
		
		return target;
	}

}
