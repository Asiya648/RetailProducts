package com.retailprod.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	
	private String productId;
	private String title;
	private Price price;
	private List<ColorSwatch> colorSwatches = new ArrayList<>();
	
	
}
