package com.retailprod.model;

public enum CurrencyIconEnum {
	GBP("Ã‚Â£"), USD("$"), EUR("Ã¢â€šÂ¬");
	
	private String icon;

	CurrencyIconEnum(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return this.icon;
    }
    
}
