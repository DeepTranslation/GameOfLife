package Model;
import java.util.Arrays;

public class Map {
    private boolean[][] map;
    
    public  Map(int width, int height) {
        this.map =  new boolean[width][height];
        for (int x = 0; x < this.map.length; x++) {
            Arrays.fill(this.map[x], false);
        }
//        this.map[2][3]=1;
//        this.map[4][7]=1;
//        System.out.print(this.map[3][4]);
    }
    
    public int getWidth() {
        return map.length;
    }
    
    public int getWidth() {
        return map.length;
    }
    
    public void drawMap() {
        for (int x = 0; x< this.map.length; x++) {
            for (int y = 0; y < this.map[x].length; y++) {
                System.out.print(this.map[x][y]);
            }
            System.out.println();
        }
    }
    
    public boolean getPixel(int x, int y) {
        if (x<= getSize() ) {
            return this.map[x][y];
        } 
        return false;//throws exception
    }
    
    public void setPixel(int x, int y) {
        
        this.map[x][y] = true;
    }
    
    public void clearPixel(int x, int y) {
        this.map[x][y] = false;
    }
    
}
