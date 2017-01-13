/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.alite.ishjava2;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luka
 */
public abstract class IshGame implements Runnable {
    private String title;
    private JPanel mainPanel;
    private JFrame mainFrame;
    private Graphics globalGraphics;
    
    private Thread gameThread;
    
    private ArrayList<Sprite> spriteList;
    
    public IshGame() {
        
        mainFrame = new JFrame("IshGame 2");
        mainPanel = new JPanel();
        
        mainFrame.setBounds(0, 0, 1280, 720);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setVisible(true);
        
        globalGraphics = mainPanel.getGraphics();
        
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameThread != null) {
                    gameThread = null;
                    start.setText("Start");
                }
                
                else {
                    start();
                    start.setText("Stop");
                }
            }
            
        });
        
        mainFrame.add(start);
        
        onCreate();
    }
    
    public final String getTitle() {
        return title;
    }
    
    public final void setTitle(String title) {
        mainFrame.setTitle(title);
        this.title = title;
    }
    
    @Override
    public void run() {
        long nanosec = System.nanoTime();
        while (gameThread != null) {
            long delay = (long)1e9 / 60;
            System.out.println("loop");
            while (System.nanoTime() < nanosec + delay) {
                Thread.yield();
            }
            nanosec = System.nanoTime();
        }
    }
    
    public final void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public final void addSpriteToScene(Sprite sprite) throws Exception {
        
        for (Sprite sprite2 : spriteList) {
            if (sprite2.name.equals(sprite.name)) {
                throw new Exception("Another object with the same name is already on the stage!");
            }
        }
        
        spriteList.add(sprite);
    }
    
    public final Sprite getSpriteWithName(String name) {
        
        for (Sprite sprite : spriteList) {
            if (sprite.name.equals(name)) {
                return sprite;
            }
        }
        
        return null;
    }
    
    public abstract void onCreate();
}
