package View;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import View.Controller.ChangeMapListener;



public class MainFrame extends JFrame{  
    public CellCanvas canvas;
    private JLabel label;
    private Panel controlPanel;
    //private Panel viewPanel;
    private JButton startButton;
    private JButton stopButton;
    //private JTextArea textArea;
    
    
    public MainFrame() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Game of Life");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
//        canvas = new CellCanvas();
//       //canvas.setBackground(Color.BLACK);
//       // canvas.setBackground(Color.decode("#9B9B7A"));
//        //canvas.addPropertyChangeListener(new Canvas);
//        canvas.setBackground(Color.decode(colors.MAPBACKGROUND.hexCode));
////        canvas.addPropertyChangeListener(new CanvasMouseListener());
////        canvas.addMouseListener(new CanvasClickListener());
//        add(canvas,BorderLayout.CENTER);
//        Dimension canvasSize = canvas.getSize();
//        if (canvasSize.height < canvasSize.width) {
//            canvasSize.setSize(canvasSize.height, canvasSize.height);
//        } else {
//            canvasSize.setSize(canvasSize.width, canvasSize.width);
//        }

        // Control Panel
        label = new JLabel("Info");
        startButton=new JButton("Start");
        stopButton=new JButton("Stop");
        
        controlPanel = new Panel();
        controlPanel.setLayout(new GridLayout(1,3));
        controlPanel.add(label,0,0);
        controlPanel.add(startButton,0,1);
        controlPanel.add(stopButton,0,2);
        controlPanel.setBackground(Color.decode(colors.PANEL.hexCode));
        add(controlPanel,BorderLayout.SOUTH);
        setVisible(true);
    }
    
//    public void drawCanvasGrid(boolean[][] map) {
//        canvas.update(map);
//        canvas.drawGrid();
//    }
    
    public void setStartButtonListener(MouseListener listener) {
        startButton.addMouseListener( listener);
    }
    
    public void setStopButtonListener(MouseListener listener) {
        stopButton.addMouseListener( listener);
    }    
     
//    public void setCanvasClickListener() {
//        canvas.addPropertyChangeListener(new CanvasMouseListener);
//    }
    
//    public class CanvasMouseListener  extends MouseAdapter   {
//        @Override
//        public void mouseReleased(MouseEvent event)  {
//            System.out.println("inside CanvasMouseListener");
////            ui.doStuff(4,5);
////            doStuff(event.getPoint());
////            event.getPoint()
////            myMap.setPixel((int)e.getOldValue(), (int)e.getNewValue());
//         //   canvasClicks.firePropertyChange( "canvas", event.getY(), event.getX());
//        }
//      }
}  
