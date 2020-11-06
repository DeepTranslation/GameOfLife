package Model;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        
        
        Map myMap = new Map(10,10);
       
        
        System.out.println(myMap.getPixel(3,4));
        myMap.drawMap();
        System.out.println("---------------------");
        myMap.setPixel(5, 5);
        myMap.setPixel(0, 7);
        char[][] mapArray = myMap.getMap();
        

        for (int x =0; x<mapArray.length; x++) {
            for (int y = 0; y<mapArray[0].length; y++) {
                System.out.print(mapArray[x][y]);
            }
            System.out.println();
        }
        
        System.out.println("---------------------");
        Map testMap = new Map(3,3);
        char[][] testArray = {
                {'.','.','.'},
                {'.','X','X'},
                {'.','.','.'}
            };
        
        
        testMap.setMap(testArray);
        testMap.drawMap();
        char[][] getArray = testMap.getMap();
        for (int x =0; x<getArray.length; x++) {
            for (int y = 0; y<getArray[0].length; y++) {
                System.out.print(getArray[x][y]);
            }
            System.out.println();
        }
        System.out.println(Arrays.equals(getArray,testArray));
    }

}
