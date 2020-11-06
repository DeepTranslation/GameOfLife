package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Map;

public class NextGenerationTest {
private Map testMap;
    
    @BeforeEach
    public void mapInit() {
        this.testMap = new Map(5,5);
    }
    
    @Test
    public void mapInitTest() { 
        testMap.setPixel(1, 1);
        testMap.setPixel(1, 2);
        testMap.setPixel(2, 1);
        testMap.setPixel(2, 2);
       
        assertEquals(false, this.testMap.getPixel(x, y));
    }
    
    
    @Test
    public void setAndClearPixelTest() { 
        
        int x= 0;
        int y=0;
        testMap.setPixel(x, y);
        assertEquals(true, testMap.getPixel(x, y));
        testMap.clearPixel(x, y);
        assertEquals(false, testMap.getPixel(x, y));
        x= 3;
        y=4;
        testMap.setPixel(x, y);
        assertEquals(true, testMap.getPixel(x, y));
        testMap.clearPixel(x, y);
        assertEquals(false, testMap.getPixel(x, y));
    }
}
