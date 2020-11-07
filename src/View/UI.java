package View;

import java.awt.event.*;
import java.util.Scanner;

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
        
        mainFrame.setVisible(true);
        
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
        
        /*
        Scanner scanner = new Scanner(System.in);
        String input;
        //myMap = new Map(10,10);
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
        while (true) {
            
            input = scanner.nextLine();
            if (input.equals("o")) {
                break;
            }
            
            myMap.nextGeneration();
            myMap.drawMap();
            char[][] newArray = myMap.getMapArray();
            mainFrame.drawMap(newArray);
        }*/
        
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
          //myMap.drawMap();
          char[][] newArray = myMap.getMapArray();
          mainFrame.drawMap(newArray);
          drawRow++;
          drawColumn++;
          mainFrame.drawCanvasGrid(myMap.getHeight(), myMap.getWidth(), newArray);
      }
    }
    
    

}
