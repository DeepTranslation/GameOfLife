package Model;
import java.util.Arrays;

public class Map {
    private boolean[][] map;
    
    public  Map(int width, int height) {
        this.map =  new boolean[width][height];
        for (int x = 0; x < this.map.length; x++) {
            Arrays.fill(this.map[x], false);
        }
        this.map[2][3]=true;
        this.map[4][7]=true;
        System.out.print(this.map[3][4]);
    }
    
    public int getWidth() {
        return map.length;
    }
    
    public int getHeight() {
        return map[1].length;
    }
    
    public void drawMap() {
        char output;
        for (int x = 0; x< getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (this.map[x][y]) {
                     output = 'X';
                } else {
                    output = '.';
                }
                    
                System.out.print(output);
            }
            System.out.println();
        }
    }
    
    public boolean getPixel(int x, int y) {
        
            return this.map[x][y];
     }
    
    public void setPixel(int x, int y) {
        
        this.map[x][y] = true;
    }
    
    public char[][] getMap(){
        char[][] outputMap = new char[getWidth()][getHeight()];
        for (int x = 0; x< getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (this.map[x][y]) {
                     outputMap[x][y] = 'X';
                } else {
                    outputMap[x][y] = '.';
                }
            }
        }
        return outputMap;
    }
    
    public void setMap(char[][] inputMap){
        
        for (int x = 0; x< getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (inputMap[x][y]=='X') {
                     this.map[x][y] = true;
                } else {
                    this.map[x][y] = false;
                }
            }
        }
        
    }
    
    public void clearPixel(int x, int y) {
        this.map[x][y] = false;
    }
    
}
