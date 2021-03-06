package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

public class Map {
    private boolean[][] map;
    private int height;
    private int width;
    private PropertyChangeSupport mapChanges;
    
    /**
     * Map Constructor,
     * coordinates sorted in matrix style, row first, column second
     * @param   map height (one unit per organism)
     *                 map width   (one unit per organism)
     */
    public  Map(int height, int width ) {
        this.map =  new boolean[height][width];
        for (int y = 0; y < this.map.length; y++) {
            Arrays.fill(this.map[y], false);
        this.height = height;
        this.width = width;
        mapChanges = new PropertyChangeSupport( this ); 
        //changes.firePropertyChange( "map", null,this.map);
        }
    }
    

    /**
     * Calculate the next generation of the map and update the map accordingly
     */
    public void nextGeneration() {
       Map nextMap = new Map(getHeight(),getWidth());
       int neighbours;
       for  (int row = 0; row< getHeight(); row++) {
           for (int column = 0; column < getWidth(); column++  ) {
               neighbours = countNeighbours(row, column );
               
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
       boolean[][] oldMap = this.map;
       this.map = nextMap.map;
       mapChanges.firePropertyChange( "map", oldMap, this.map );
       
    }
    
    /**
     * Counts number of neighbouring organisms of one cell
     * @param row 
     * @param column
     * @return number of neighbours
     */
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

        for (int currentRow = startRow; currentRow<= endRow; currentRow++) {
            for (int currentColumn = startColumn; currentColumn <= endColumn; currentColumn++  ) {
                if (!((currentRow==row) && (currentColumn==column))) {
                    if (getPixel(currentRow,currentColumn)) {
                        count++;
                    }
                }
            }
            
        }
        return count;
    }
    
    /**
     * get map width
     * @return map width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * get map height
     * @return map height
     */
    public int getHeight() {
        return height;
    }
    
    
    /**
     * Returns the set status of an individual cell
     */
    public boolean getPixel(int row, int column) {
            return this.map[row][column];
     }
    
    /** 
     * sets one individual cell to true
     */
    public void setPixel(int row, int column ) {
        this.map[row][column] = true;
        
    }
    
    /**
     * sets one individual cell to false
     */
    public void clearPixel(int row, int column) {
        this.map[row][column] = false;
    }
    
    
    /**
     * gets the whole map as a 2D Array
     * --- only used for testing ---
     * @return 2D Array of char
     *                  X = cell alive
     *                  . = cell dead
     */
    public char[][] getMapArray(){
        char[][] outputMapArray = new char[getHeight()][getWidth()];
        for (int row = 0; row< getHeight(); row++) {
            for (int column = 0; column < getWidth(); column++) {
                if (this.map[row][column]) {
                    outputMapArray[row][column] = 'X';
                } else {
                    outputMapArray[row][column] = '.';
                }
            }
        }
        return outputMapArray;
    }
    
    /**
     * sets the whole map to the parameter values
     * --- only used for initialising the map  ----
     * @param inputMap = 2D Array
     *                  X = cell alive
     *                  . = cell dead
     */
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
        mapChanges.firePropertyChange( "map", null,this.map);
    }
    
    public void addPropertyChangeListener( PropertyChangeListener l )
    {
      mapChanges.addPropertyChangeListener( l );
    }

    public void removePropertyChangeListener( PropertyChangeListener l )
    {
      mapChanges.removePropertyChangeListener( l );
    }


    public void clearMap() {
        for (int row = 0; row < this.map.length; row++) {
            Arrays.fill(this.map[row], false);
        }
        mapChanges.firePropertyChange( "map", null,this.map);
    }


    public void randomMap() {
        for (int row = 0; row < this.map.length; row++) {
            for (int column = 0; column < this.map.length; column++) {
               if (Math.random() < 0.5) {
                   this.setPixel(row , column);
               }else {
                   this.clearPixel(row , column);
               }
            }
           
        }
        mapChanges.firePropertyChange( "map", null,this.map);
        
    }
    
    public void randomLinesMap() {
        for (int y = 0; y < this.map.length; y++) {
            Arrays.fill(this.map[y], (Math.random() < 0.5));
        }
        mapChanges.firePropertyChange( "map", null,this.map);
        
    }

}
