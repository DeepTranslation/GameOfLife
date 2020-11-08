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
    private JButton clearButton;
    private JButton randomButton;
    private JButton randomLinesButton;
    
    
    public MainFrame() {
        initUI();
    }

    private void initUI() {
        
        setTitle("Game of Life");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());

        // Control Panel
        label = new JLabel("Info");
        startButton=new JButton("Start");
        stopButton=new JButton("Stop");
        clearButton=new JButton("Clear");
        randomButton=new JButton("Random");
        randomLinesButton=new JButton("Random Lines");
        
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
//        controlPanel.setLayout(new GridLayout(1,5));
        controlPanel.add(label,0,0);
        controlPanel.add(randomButton,0,1);
        controlPanel.add(randomLinesButton,0,2);
        controlPanel.add(clearButton,0,3);
        controlPanel.add(startButton,0,4);
        controlPanel.add(stopButton,0,5);
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
    
    public void setClearButtonListener(MouseListener listener) {
        clearButton.addMouseListener( listener);
    }
    
    public void setRandomButtonListener(MouseListener listener) {
        randomButton.addMouseListener( listener);
    }
    public void setRandomLinesButtonListener(MouseListener listener) {
        randomLinesButton.addMouseListener( listener);
    }
}  
