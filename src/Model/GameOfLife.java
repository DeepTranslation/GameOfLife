package Model;

public class GameOfLife {

    public static void main(String[] args) {
        
        
        Map myMap = new Map(10,10);
       
        
        System.out.println(myMap.getPixel(3,4));
        myMap.drawMap();
        
        char[][] mapArray = myMap.getMap();
        System.out.println(mapArray);
        
    }

}
