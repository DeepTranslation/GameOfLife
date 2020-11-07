package View;


import java.awt.*;

import javax.swing.*;  

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
        
        
        JButton startButton=new JButton("Start");
        JButton stopButton=new JButton("Stop");
        
        controlPanel.add(startButton,0,1);
        controlPanel.add(stopButton,0,1);
        
//        add(canvas, BorderLayout.CENTER);
        add(textArea, BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        setVisible(true);
    }
    
        /*JFrame mainFrame=new JFrame();//creating instance of JFrame  
        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        JButton button=new JButton("Start");//creating instance of JButton  
        //b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
        mainFrame. .setLayout(new BorderLayout());
        mainFrame.add(b);//adding button in JFrame  
                  
        mainFrame.setSize(400,500);//400 width and 500 height  
        mainFrame.setLayout(null);//using no layout managers  
        mainFrame.setVisible(true);//making the frame visible  
      */
}  
