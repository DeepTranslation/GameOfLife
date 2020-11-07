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
        this.testMap = new Map(5,5);
    }
    
    @Test
    public void setMapTest() { 
        char[][] testArray = {
                {'.','.','.','.','.'},
                {'.','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(testArray);
        char[][] getArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(getArray,testArray));
    }
    
    @Test
    public void BlockTest() { 
        char[][] startArray = {
                {'.','.','.','.','.'},
                {'.','X','X','.','.'},
                {'.','X','X','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','X','X','.','.'},
                {'.','X','X','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void TubTest() { 
        char[][] startArray = {
                {'.','.','.','.','.'},
                {'.','.','X','.','.'},
                {'.','X','.','X','.'},
                {'.','.','X','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','.','X','.','.'},
                {'.','X','.','X','.'},
                {'.','.','X','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void CircleTest() { 
        char[][] startArray = {
                {'.','.','.','.','.'},
                {'.','.','X','X','.'},
                {'.','X','.','.','X'},
                {'.','X','.','.','X'},
                {'.','.','X','X','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','.','X','X','.'},
                {'.','X','.','.','X'},
                {'.','X','.','.','X'},
                {'.','.','X','X','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void BoatTest() { 
        char[][] startArray = {
                {'.','.','.','X','.'},
                {'.','.','X','.','X'},
                {'.','X','.','X','.'},
                {'.','.','X','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','X','.'},
                {'.','.','X','.','X'},
                {'.','X','.','X','.'},
                {'.','.','X','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    @Test
    public void BlinkerTest() { 
        char[][] startArray = {
                {'.','.','.','.','.'},
                {'.','.','X','.','.'},
                {'.','.','X','.','.'},
                {'.','.','X','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','X','X','X','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    @Test
    public void BeaconTest() { 
        char[][] startArray = {
                {'.','.','.','.','.'},
                {'.','X','X','.','.'},
                {'.','X','X','.','.'},
                {'.','.','.','X','X'},
                {'.','.','.','X','X'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','X','X','.','.'},
                {'.','X','.','.','.'},
                {'.','.','.','.','X'},
                {'.','.','.','X','X'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void CornerOneTest() { 
        char[][] startArray = {
                {'X','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void CornerBlinkerTest() { 
        char[][] startArray = {
                {'X','X','X','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','X','.','.','.'},
                {'.','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void CornerBeaconTest() { 
        char[][] startArray = {
                {'X','X','.','.','.'},
                {'X','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'X','X','.','.','.'},
                {'X','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void CornerBlockTest() { 
        char[][] startArray = {
                {'X','X','.','.','.'},
                {'X','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
            };
        char[][] targetArray = {
                {'X','X','.','.','.'},
                {'X','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void CornerTwoTest() { 
        char[][] startArray = {
                {'X','.','.','.','.'},
                {'X','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void CornerDiagonalTest() { 
        char[][] startArray = {
                {'X','.','.','.','.'},
                {'.','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void EdgeBlinkerTest() { 
        char[][] startArray = {
                {'.','.','.','.','.'},
                {'X','.','.','.','.'},
                {'X','.','.','.','.'},
                {'X','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'X','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
    @Test
    public void EdgeBeaconTest() { 
        char[][] startArray = {
                {'.','.','.','.','.'},
                {'X','X','.','.','.'},
                {'X','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        char[][] targetArray = {
                {'.','.','.','.','.'},
                {'X','X','.','.','.'},
                {'X','X','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
            };
        testMap.setMap(startArray);
        testMap.nextGeneration();
        char[][] resultArray = testMap.getMap();
        assertEquals(true, Arrays.deepEquals(resultArray,targetArray));
    }
    
   
}
