package Model;

public class GameOfLife {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello World!");
        
        Map myMap = new Map();
        System.out.println(myMap.getPixel(3,4));
        myMap.drawMap();
    }

}