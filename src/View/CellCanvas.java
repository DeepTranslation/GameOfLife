package View;

import java.awt.*;

public class CellCanvas extends Canvas {
    private int height;
    private int width;
    private int drawRow;
    private int drawColumn;
    
    
    
    public CellCanvas() {
        super();
        this.height = 0;
        this.width = 0;
        this.drawRow = 0;
        this.drawColumn = 0;
        
        // TODO Auto-generated constructor stub
    }



    public void init(int height, int width,int drawRow, int drawColumn) {
        this.height = height;
        this.width = width;
        this.drawRow = drawRow;
        this.drawColumn = drawColumn;
        
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
        drawCell(g, drawRow,drawColumn);
    }
    
    
    
    public void drawCell(Graphics g, int row, int column) {
        int XPosition =(int) ((double )this.getWidth()/this.width *(column-1));
        int YPosition =(int) ((double )this.getHeight()/this.height * (row-1));
        int rowWidth =(int) ((double )this.getWidth()/this.width );
        int columnHeight =(int) ((double )this.getHeight()/this.height);
        
        g.fillRect(XPosition, YPosition, rowWidth, columnHeight);
    }

}
