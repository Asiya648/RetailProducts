package com.retailprod.domain;

public enum CurrencyEnum {
	GBP("Ã‚Â£"), USD("$"), EUR("Ã¢â€šÂ¬");
	
	private String value;

    public String getResponse() {
        return value;
    }

    CurrencyEnum(String value){
        this.value = value;
    }
}
