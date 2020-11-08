package View;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Map;

public class UI  {
    protected Map myMap;
    protected MainFrame mainFrame;
    protected int drawRow ;
    protected int drawColumn;

    public UI() {
        
        this.myMap = new Map(10,10);
        this.mainFrame = new MainFrame();
        this.drawRow = 0;
        this.drawColumn = 0;
        
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
        mainFrame.drawMap(startArray);
        
        mainFrame.setStartButtonListener(new MyMouseListener());
        mainFrame.drawCanvasGrid(myMap.getHeight(), myMap.getWidth(),null);
        
        
    }
    
    public class MyMouseListener   extends MouseAdapter   {
//      @Override
//      public void mousePressed(MouseEvent event)   {
//          pcModel.newLine(getColor());
//          pcModel.setColor(getColor());
//        
//      }
  
      @Override
      public void mouseReleased(MouseEvent event)  {
        
          myMap.nextGeneration();
        
          char[][] newArray = myMap.getMapArray();
          mainFrame.drawMap(newArray);
          drawRow++;
          drawColumn++;
          mainFrame.drawCanvasGrid(myMap.getHeight(), myMap.getWidth(), newArray);
      }
    }
    
    

}
