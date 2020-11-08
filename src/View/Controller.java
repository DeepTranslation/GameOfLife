package View;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import Model.Map;

public class Controller  {
    protected Map myMap;
    protected MainFrame mainFrame;
    protected javax.swing.Timer gameTimer;
    protected CellCanvas canvas;

    public Controller() {
        this.gameTimer = new javax.swing.Timer( 300, new TimerListener() );
        this.mainFrame = new MainFrame();
        this.canvas = new CellCanvas();
        this.myMap = new Map(30,30);
        canvas.setBackground(Color.decode(colors.MAPBACKGROUND.hexCode));
        mainFrame.add(canvas,BorderLayout.CENTER);
    }
    
    public void launch() {
        /*
        mainFrame.setVisible(true);
        try{ 
            mainFrame.setIconImage(ImageIO.read(new File("./resources/icon.png")));
          } 
          catch (IOException e){
            e.printStackTrace();
          }*/
//        mainFrame.setIconImage(ImageIO.read(new File("resources/icon.png")));
//        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");    
//        mainFrame.setIconImage(icon); 
        
        mainFrame.setStartButtonListener(new StartButtonListener());
        mainFrame.setStopButtonListener(new StopButtonListener());

         Dimension canvasSize = canvas.getSize();
         if (canvasSize.height < canvasSize.width) {
             canvasSize.setSize(canvasSize.height, canvasSize.height);
         } else {
             canvasSize.setSize(canvasSize.width, canvasSize.width);
         }
        canvas.addMouseListener(new CanvasMouseListener());
         
        char[][] startArray = {
                {'.','X','.','.','.','.','.','.','.','.'},
                {'.','.','X','.','.','.','.','.','.','.'},
                {'X','X','X','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
            };
        
        char[][] RIPConway = {
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','X','X','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','X','.','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','X','.','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','X','.','X','X','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','X','.','X','.','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','X','.','.','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','X','.','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','X','.','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}   
            };
        myMap.addPropertyChangeListener(new ChangeMapListener());
        myMap.setMap(RIPConway);
    }
    
    public void drawCanvasGrid(boolean[][] map) {
        canvas.update(map);
        canvas.drawGrid();
    }
    
    public void doStuff(int row, int column) {
        myMap.setPixel(row,column);
    }
    
    public class StartButtonListener  extends MouseAdapter   {
      @Override
      public void mouseReleased(MouseEvent event)  {
          gameTimer.start();
      }
    }
    
    public class StopButtonListener  extends MouseAdapter   {
        @Override
        public void mouseReleased(MouseEvent event)  {
            gameTimer.stop();
        }
      }
   
    public class ChangeMapListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent e) {
            canvas.update((boolean[][])e.getNewValue());
            canvas.drawGrid();
        }
    } 
    
    public class TimerListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            myMap.nextGeneration();
          }

    }
    
    public class CanvasMouseListener  extends MouseAdapter   {
        @Override
        public void mouseReleased(MouseEvent event)  {
            if (!gameTimer.isRunning()) {
                    
                int row = (int) ((double )event.getY()*myMap.getHeight()/canvas.getHeight());
                int column = (int) ((double )event.getX()*myMap.getWidth()/canvas.getWidth());
                if (!myMap.getPixel(row, column)) {
                    myMap.setPixel(row, column);
                } else {
                    myMap.clearPixel(row, column);
                }
                canvas.drawGrid();
            }
        }
      }
}
