package com.retailprod.domain;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Price {
	
	private Optional<Float> was;
	private Optional<Float> then1;
	private Optional<Float> then2;
	private Object now;
	

}
