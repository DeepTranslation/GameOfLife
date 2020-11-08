package View;

import java.awt.*;

public class CellCanvas extends Canvas {
    private int height;
    private int width;
    private char[][] mapArray;
    
    
    
    
    public CellCanvas() {
        super();
        this.height = 0;
        this.width = 0;
        this.mapArray = null;
        
        
        // TODO Auto-generated constructor stub
    }



    public void init(int height, int width,char[][] mapArray) {
        this.height = height;
        this.width = width;
        this.mapArray = mapArray;
        
        
    }
    
    public void drawGrid() {
        repaint();
    }
    
    @Override
    public void paint(Graphics g)  {
        int currentXPosition,currentYPosition;;
        g.setColor(Color.GRAY);
        for (int i = 0; i < this.width; i++) {
            currentXPosition =(int) ((double )this.getWidth()/this.width * i);
            g.drawLine(currentXPosition, 0,currentXPosition, this.getHeight());
        }
        for (int i = 0; i < this.height; i++) {
            currentYPosition =(int) ((double )this.getHeight()/this.height * i);
            g.drawLine(0, currentYPosition, this.getWidth(),currentYPosition);
        }
        g.setColor(Color.RED);
        if (mapArray != null) {
            drawCell(g);
        }
    }
    
    
    
    public void drawCell(Graphics g) {
        for (int row = 0; row<mapArray.length; row++) {
            for (int column = 0; column <mapArray[0].length; column++) {
                if (mapArray[row][column]== 'X') {
                    int XPosition =(int) ((double )this.getWidth()/this.width *(column));
                    int YPosition =(int) ((double )this.getHeight()/this.height * (row));
                    int rowWidth =(int) ((double )this.getWidth()/this.width*(column+1) ) -XPosition ;
                    int columnHeight =(int) ((double )this.getHeight()/this.height*(row+1))-YPosition;
                    
                    g.fillRect(XPosition+1, YPosition+1, rowWidth-1, columnHeight-1);
                }
            }
        }
        
    }

}
