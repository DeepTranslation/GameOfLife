package test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Map;


public class MapTest {
    private Map testMap;
    
    @BeforeEach
    public void mapInit() {
        this.testMap = new Map();
    }
    
    @Test
    public void mapInitTest() { 
        
        int x= 0;
        int y=0;
        assertEquals(0, this.testMap.getPixel(x, y));
    }
    
    
    @Test
    public void setAndClearPixelTest() { 
        
        int x= 0;
        int y=0;
        testMap.setPixel(x, y);
        assertEquals(1, testMap.getPixel(x, y));
        testMap.clearPixel(x, y);
        assertEquals(0, testMap.getPixel(x, y));
        x= 3;
        y=4;
        testMap.setPixel(x, y);
        assertEquals(1, testMap.getPixel(x, y));
        testMap.clearPixel(x, y);
        assertEquals(0, testMap.getPixel(x, y));
    }
    
    
}
