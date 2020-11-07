package Model;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        
        
        Map myMap = new Map(5,10);
       
        
        System.out.println(myMap.getPixel(3,4));
        myMap.drawMap();
        System.out.println("---------------------");
        myMap.setPixel(4, 7);
        myMap.setPixel(0, 7);
        char[][] mapArray = myMap.getMap();
        

        for (int y =0; y<mapArray.length; y++) {
            for (int x = 0; x<mapArray[0].length; x++) {
                System.out.print(mapArray[y][x]);
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
        char[][] testArray2 = {
                {'.','.','.'},
                {'.','X','X'},
                {'.','.','.'}
            };
        char[] testArray3 =  {'.','.','.', '.','X','X'};
        char[] testArray4 =  {'.','.','.', '.','X','X'};
        testMap.drawMap();
        System.out.println("---------------------");
        testMap.setMap(testArray);
        testMap.drawMap();
        System.out.println("---------------------");
        char[][] getArray = testMap.getMap();
        for (int row =0; row<getArray.length; row++) {
            for (int column = 0; column<getArray[0].length; column++) {
                System.out.print(getArray[row][column]);
            }
            System.out.println();
        }
        System.out.println(Arrays.deepEquals(testArray2,testArray));
    }

}
