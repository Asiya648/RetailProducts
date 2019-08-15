package com.retailprod.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class ProductModel {
	
	private String id;
	private String title;
	private String nowPrice;
	private String priceLabel;
	private Float discount;
	private List<ColorSwatchModel> colorSwatches = new ArrayList<>();
	
}
