package View;




import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListDataListener;



public class MainFrame extends JFrame{  
    private CellCanvas canvas;
    private JLabel label;
    private Panel controlPanel;
    private Panel viewPanel;
    private JButton startButton;
    private JButton stopButton;
    private JTextArea textArea;
    
    
    public MainFrame() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Game of Life");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        canvas = new CellCanvas();
       //canvas.setBackground(Color.BLACK);
       // canvas.setBackground(Color.decode("#9B9B7A"));
        canvas.setBackground(Color.decode(colors.MAPBACKGROUND.hexCode));
      
        add(canvas,BorderLayout.CENTER);
        Dimension canvasSize = canvas.getSize();
        if (canvasSize.height < canvasSize.width) {
            canvasSize.setSize(canvasSize.height, canvasSize.height);
        } else {
            canvasSize.setSize(canvasSize.width, canvasSize.width);
        }

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
    
    public void drawCanvasGrid(int height, int width, boolean[][] map) {
        canvas.update(height, width, map);
        canvas.drawGrid();
    }
    
    public void setStartButtonListener(MouseListener listener) {
        startButton.addMouseListener( listener);
    }
    
    public void setStopButtonListener(MouseListener listener) {
        stopButton.addMouseListener( listener);
    }    
     
}  
