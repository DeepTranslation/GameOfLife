package View;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Map;

public class UI  {
    protected Map myMap;
    protected MainFrame mainFrame;
    protected javax.swing.Timer gameTimer;

    public UI() {
        this.gameTimer = new javax.swing.Timer( 300, new TimerListener() );
        this.mainFrame = new MainFrame();
        this.myMap = new Map(10,10);
        
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
        myMap.addPropertyChangeListener(new CangeMapListener());
        myMap.setMap(startArray);
        
        
        
        mainFrame.setStartButtonListener(new StartButtonListener());
        mainFrame.setStopButtonListener(new StopButtonListener());
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
    
    public class CangeMapListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent e) {
            mainFrame.drawCanvasGrid(myMap.getHeight(), myMap.getWidth(),(boolean[][])e.getNewValue());
        }
    } 
    
    public class TimerListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            myMap.nextGeneration();
          }

    }

}
