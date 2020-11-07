package Model;
import java.util.Arrays;

public class Map {
    private boolean[][] map;
    private int height;
    private int width;
    
    public  Map(int height, int width ) {
        this.map =  new boolean[height][width];
        for (int y = 0; y < this.map.length; y++) {
            Arrays.fill(this.map[y], false);
        this.height = height;
        this.width = width;
            
            
        }
//        this.map[2][3]=true;
//        this.map[4][7]=true;
//        System.out.print(this.map[3][4]);
    }
    
    public void nextGeneration() {
       Map nextMap = new Map(getHeight(),getWidth());
       int neighbours;
       for  (int row = 0; row< getHeight(); row++) {
           for (int column = 0; column < getWidth(); column++  ) {
               neighbours = countNeighbours(column, row);
               
//               Any live cell with two or three live neighbours survives.
               if (getPixel(row,column)&& (neighbours==2 || neighbours == 3)) {
                   nextMap.setPixel(row,column);
               }
//               Any dead cell with three live neighbours becomes a live cell.
               if (!getPixel(row,column)&&  neighbours == 3) {
                   nextMap.setPixel(row,column);
               }
//               All other live cells die in the next generation. Similarly, all other dead cells stay dead.
               ; //map initialised to false 
           }
       }
       this.map = nextMap.map;
       
    }
    
    private int countNeighbours(int row, int column) {
        int count = 0;
        int startRow, startColumn;
        int endRow, endColumn;
        if (row == 0) {
            startRow = 0;
            endRow = 1;
        } else if (row == height-1) {
            startRow = row-1;
            endRow = row;
        } else {
            startRow = row-1;
            endRow = row+1;
        }
        if (column == 0) {
            startColumn = 0;
            endColumn = 1;
        } else if (column == width-1) {
            startColumn = column-1;
            endColumn = column;
        } else {
            startColumn = column-1;
            endColumn = column+1;
        }

        for (int currentRow = startRow; row<= endRow; row++) {
            for (int currentColumn = endColumn; column <= startColumn; column++  ) {
                if (!(currentRow==row) && !(currentColumn==column)) {
                    if (getPixel(currentRow,currentColumn)) {
                        count++;
                    }
                }
            }
            
        }
        
        
        return count;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void drawMap() {
        char output;
        for (int row = 0; row< getHeight(); row++) {
            for (int column = 0; column < getWidth(); column++) {
                if (this.map[row][column]) {
                     output = 'X';
                } else {
                    output = '.';
                }
                    
                System.out.print(output);
            }
            System.out.println();
        }
    }
    
    public boolean getPixel(int row, int column) {
        
            return this.map[row][column];
     }
    
    public void setPixel(int row, int column ) {
        
        this.map[row][column] = true;
    }
    
    public char[][] getMap(){
        char[][] outputMap = new char[getHeight()][getWidth()];
        for (int row = 0; row< getHeight(); row++) {
            for (int column = 0; column < getWidth(); column++) {
                if (this.map[row][column]) {
                     outputMap[row][column] = 'X';
                } else {
                    outputMap[row][column] = '.';
                }
            }
        }
        return outputMap;
    }
    
    public void setMap(char[][] inputMap){
        
        for (int row = 0; row< getHeight(); row++) {
            for (int column = 0; column < getWidth(); column++) {
                if (inputMap[row][column]=='X') {
                     this.map[row][column] = true;
                } else {
                    this.map[row][column] = false;
                }
            }
        }
        
    }
    
    public void clearPixel(int row, int column) {
        this.map[row][column] = false;
    }
    
}
