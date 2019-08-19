package com.retailprod.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.retailprod.domain.ColorSwatch;
import com.retailprod.model.ColorSwatchModel;

public class ColorSwatchToColorSwatchModelConverterTest {

//	private static final String BASIC_COLOR = "Red";
    private static final String SKU_ID = "237494589";
    private static final String COLOR = "Wine";
    

    ColorSwatchToColorSwatchModelConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new ColorSwatchToColorSwatchModelConverter();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new ColorSwatch()));
    }

    @Test
    public void given_colorSwatch_and_basicColorIsRed_when_convertColorSwatchToColorSwatchModel_then_returnColorSwatchModel() throws Exception {
        
    	//given
    	ColorSwatch colorSwatch = new ColorSwatch("Red", SKU_ID, COLOR);

        //when
    	ColorSwatchModel colorSwatchModel = converter.convert(colorSwatch);

        //then
    	
        assertEquals("FF0000", colorSwatchModel.getRgbColor());
        assertEquals(SKU_ID, colorSwatchModel.getSkuid());
        assertEquals(COLOR, colorSwatchModel.getColor());
    }
    
    @Test
    public void given_colorSwatch_and_basicColorIsGreen_when_convertColorSwatchToColorSwatchModel_then_returnColorSwatchModel() throws Exception {
        
    	//given
    	ColorSwatch colorSwatch = new ColorSwatch("Green", SKU_ID, COLOR);

        //when
    	ColorSwatchModel colorSwatchModel = converter.convert(colorSwatch);

        //then
    	
        assertEquals("00FF00", colorSwatchModel.getRgbColor());
        assertEquals(SKU_ID, colorSwatchModel.getSkuid());
        assertEquals(COLOR, colorSwatchModel.getColor());
    }
    
    @Test
    public void given_colorSwatch_and_basicColorIsBlue_when_convertColorSwatchToColorSwatchModel_then_returnColorSwatchModel() throws Exception {
        
    	//given
    	ColorSwatch colorSwatch = new ColorSwatch("Blue", SKU_ID, COLOR);

        //when
    	ColorSwatchModel colorSwatchModel = converter.convert(colorSwatch);

        //then
    	
        assertEquals("0000FF", colorSwatchModel.getRgbColor());
        assertEquals(SKU_ID, colorSwatchModel.getSkuid());
        assertEquals(COLOR, colorSwatchModel.getColor());
    }
    
    @Test
    public void given_colorSwatch_and_basicColorIsWhite_when_convertColorSwatchToColorSwatchModel_then_returnColorSwatchModel() throws Exception {
        
    	//given
    	ColorSwatch colorSwatch = new ColorSwatch("White", SKU_ID, COLOR);

        //when
    	ColorSwatchModel colorSwatchModel = converter.convert(colorSwatch);

        //then
    	
        assertEquals("FFFFFF", colorSwatchModel.getRgbColor());
        assertEquals(SKU_ID, colorSwatchModel.getSkuid());
        assertEquals(COLOR, colorSwatchModel.getColor());
    }
    @Test
    public void given_colorSwatch_and_basicColorIsBlack_when_convertColorSwatchToColorSwatchModel_then_returnColorSwatchModel() throws Exception {
        
    	//given
    	ColorSwatch colorSwatch = new ColorSwatch("Black", SKU_ID, COLOR);

        //when
    	ColorSwatchModel colorSwatchModel = converter.convert(colorSwatch);

        //then
    	
        assertEquals("000000", colorSwatchModel.getRgbColor());
        assertEquals(SKU_ID, colorSwatchModel.getSkuid());
        assertEquals(COLOR, colorSwatchModel.getColor());
    }

}
