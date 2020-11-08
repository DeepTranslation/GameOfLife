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

    public UI() {
        this.myMap = new Map(10,10);
        this.mainFrame = new MainFrame();
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
        myMap.setMap(startArray);
        myMap.addPropertyChangeListener(new CangeMapListener());
       // mainFrame.drawMap(startArray);
        mainFrame.setStartButtonListener(new MyMouseListener());
    }
    
    public class MyMouseListener  extends MouseAdapter   {
//      @Override
//      public void mousePressed(MouseEvent event)   {
//          pcModel.newLine(getColor());
//          pcModel.setColor(getColor());
//      }
  
      @Override
      public void mouseReleased(MouseEvent event)  {
          myMap.nextGeneration();
//          char[][] newArray = myMap.getMapArray();
//          mainFrame.drawMap(newArray);

      }
    }
    
    public class CangeMapListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent e) {
            mainFrame.drawCanvasGrid(myMap.getHeight(), myMap.getWidth(),(boolean[][])e.getNewValue());
        }
    } 

}
