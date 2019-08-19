package com.retailprod.domain;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColorSwatch {
	private String rgbColor;
	private String skuId;
	private String color;
}
