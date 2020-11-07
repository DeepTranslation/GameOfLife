package View;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListDataListener;



public class MainFrame extends JFrame{  
    private Canvas canvas;
    private JLabel label;
    private Panel controlPanel;
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
        
        textArea = new JTextArea(
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" 
            );
        textArea.setFont(new Font("Courier", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        
//        canvas = new Canvas();
//        canvas.setBackground(Color.BLACK);
        label = new JLabel("Info");

        controlPanel = new Panel();
        controlPanel.setLayout(new GridLayout(1,3));
        controlPanel.add(label,0,0);
        
        
        startButton=new JButton("Start");
       // startButton.addMouseListener( new MyMouseListener());
        stopButton=new JButton("Stop");
        
        controlPanel.add(startButton,0,1);
        
        controlPanel.add(stopButton,0,1);
        
//        add(canvas, BorderLayout.CENTER);
        add(textArea, BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        setVisible(true);
    }
    
    public void setStartButtonListener(MouseListener listener) {
        startButton.addMouseListener( listener);
    }
    
     public void drawMap(char[][] mapArray) {
         
         StringBuilder text = new StringBuilder();
         for (int row = 0; row<mapArray.length; row++) {
             text.append(String.valueOf(mapArray[row])+"\n");
         }
         textArea.setText(text.toString());
//         textArea.update(g);
         
     }
     
     
}  
