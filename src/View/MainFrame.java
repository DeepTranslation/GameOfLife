package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{  
    public CellCanvas canvas;
    private JLabel label;
    private Panel controlPanel;
    private JButton startButton;
    private JButton stopButton;
    
    
    public MainFrame() {
        initUI();
    }

    private void initUI() {
        
        setTitle("Game of Life");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());

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
     
}  
