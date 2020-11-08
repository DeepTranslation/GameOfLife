package View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/** Graphical representation 
 * 
 * @author Anne
 *
 */
public class CellCanvas extends Canvas {
    private int height;
    private int width;
    private boolean[][] map;
    public PropertyChangeSupport canvasClicks;

    public CellCanvas() {
        super();
        this.height = 0;
        this.width = 0;
        this.map = null;
        canvasClicks = new PropertyChangeSupport( this ); 
    }

    /**
     * Update current map
     */
    public void update(boolean[][] newMap) {
        this.height = newMap.length;
        this.width = newMap[0].length;
        this.map = newMap;
    }
    
    public void drawGrid() {
        repaint();
    }
    
    @Override
    public void paint(Graphics g)  {
        int currentXPosition,currentYPosition;;
        //g.setColor(Color.GRAY);
        g.setColor(Color.decode(colors.MAPGRIDLINES.hexCode));
        
        for (int i = 0; i < this.width; i++) {
            currentXPosition =(int) ((double )this.getWidth()/this.width * i);
            g.drawLine(currentXPosition, 0,currentXPosition, this.getHeight());
        }
        for (int i = 0; i < this.height; i++) {
            currentYPosition =(int) ((double )this.getHeight()/this.height * i);
            g.drawLine(0, currentYPosition, this.getWidth(),currentYPosition);
        }
        //g.setColor(Color.RED);
        g.setColor(Color.decode(colors.ORGANISM.hexCode));
        if (map != null) {
            drawCell(g);
        }
    }
    
   public void drawCell(Graphics g) {
        for (int row = 0; row<map.length; row++) {
            for (int column = 0; column <map[0].length; column++) {
                if (map[row][column]) {
                    int XPosition =(int) ((double )this.getWidth()/this.width *(column));
                    int YPosition =(int) ((double )this.getHeight()/this.height * (row));
                    int rowWidth =(int) ((double )this.getWidth()/this.width*(column+1) ) -XPosition ;
                    int columnHeight =(int) ((double )this.getHeight()/this.height*(row+1))-YPosition;
                    
                    g.fillRect(XPosition+1, YPosition+1, rowWidth-1, columnHeight-1);
                }
            }
        }
        
    }
   
//   public class CanvasMouseListener  extends MouseAdapter   {
//       @Override
//       public void mouseReleased(MouseEvent event)  {
//           Point coordinates = new Point(event.getY(), event.getX());
//           canvasClicks.firePropertyChange( "canvas", null, coordinates);
//       }
//     }
   
   @Override
   public void addPropertyChangeListener( PropertyChangeListener l )
   {
      canvasClicks.addPropertyChangeListener( l );
   }

   @Override
   public void removePropertyChangeListener( PropertyChangeListener l )
   {
       canvasClicks.removePropertyChangeListener( l );
   }


}
