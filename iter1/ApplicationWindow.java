import iter2_jpanel_main_canvas.MainCanvas;
import iter3_jpanel_grid_canvas.GridCanvas;
import iter4_fillarc_strategy.ColorStrategy;
import iter4_fillarc_strategy.DefaultColorStrategy;
import iter4_fillarc_strategy.RandomColorStrategy;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationWindow implements ActionListener {
    private JFrame topCon;
    private ColorStrategy colorStrategy = new DefaultColorStrategy();

    public ApplicationWindow(int w, int h){
        topCon = new JFrame("Composite in Action");
        topCon.setSize(w, h);
        topCon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        topCon.setJMenuBar(menuBar);
        JMenu colorMenu = new JMenu("Color Option");
        menuBar.add(colorMenu);
        JMenuItem defaultColors = new JMenuItem("Default");
        defaultColors.addActionListener(this);
        JMenuItem randomColors = new JMenuItem("Random");
        randomColors.addActionListener(this);
        colorMenu.add(defaultColors);
        colorMenu.add(randomColors);

        topCon.add(new MainCanvas(w,h));
        topCon.pack();
        topCon.setVisible(true);
        setColorGridCanva();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        topCon.setVisible(false);

        if (command.equals("Default")){
            colorStrategy = new DefaultColorStrategy();
        }
        else if(command.equals("Random")){
            colorStrategy = new RandomColorStrategy();
        }
        
        setColorGridCanva();
        
        topCon.setVisible(true);
    }

    private void setColorGridCanva() {
        Component[] components = topCon.getContentPane().getComponents();
        for (Component comp : components) {
            if (comp instanceof MainCanvas) {
                MainCanvas mainCanvas = (MainCanvas) comp;
                Component[] gridCanvases = mainCanvas.getComponents();
                for (Component gridCanvas : gridCanvases) {
                    if (gridCanvas instanceof GridCanvas) {
                        GridCanvas gc = (GridCanvas) gridCanvas;
                        gc.setColors(colorStrategy);
                    }
                }
            }
        }
    }



    public ApplicationWindow(){
        this(600,600);
    }
}