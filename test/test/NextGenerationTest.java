package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Map;

public class NextGenerationTest {
    private Map testMap;
    
    @BeforeEach
    public void mapInit() {
        this.testMap = new Map(3,3);
    }
    
    @Test
    public void setMapTest() { 
       
        char[][] testArray = {
                {'.','.','.'},
                {'.','X','.'},
                {'.','.','.'}
            };
        
        
        testMap.setMap(testArray);
        char[][] getArray = testMap.getMap();
        assertEquals(true, Arrays.equals(getArray,testArray));
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
