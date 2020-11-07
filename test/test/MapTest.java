package test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Map;


public class MapTest {
    private Map testMap;
    
    @BeforeEach
    public void mapInit() {
        this.testMap = new Map(10,10);
    }
    
    @Test
    public void mapInitTest() { 
        
        int row= 0;
        int column=0;
        assertEquals(false, this.testMap.getPixel(row, column));
    }
    
    
    @Test
    public void setAndClearPixelTest() { 
        
        int row= 0;
        int column=0;
        testMap.setPixel(row, column);
        assertEquals(true, testMap.getPixel(row, column));
        testMap.clearPixel(row, column);
        assertEquals(false, testMap.getPixel(row, column));
        row= 3;
        row=4;
        testMap.setPixel(row, column);
        assertEquals(true, testMap.getPixel(row, column));
        testMap.clearPixel(row, column);
        assertEquals(false, testMap.getPixel(row, column));
    }
    
    
}
