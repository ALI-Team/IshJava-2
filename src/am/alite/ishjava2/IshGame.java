/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.alite.ishjava2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author luka
 */
public class IshGame implements Runnable {
    private String title;
    private Scene mainPanel;
    private JFrame mainFrame;
    private Graphics globalGraphics;
    private JButton start;
    private JButton stop;
    
    private Thread gameThread;
    
    private ArrayList<Sprite> spriteList;
    
    public boolean running;
    
    public IshGame(int resX, int resY, String title) {
        
        mainPanel = new Scene();
        mainPanel.setBounds(0, 0, resX, resY);
        mainPanel.setBorder(new EmptyBorder((int)0, (int)0, (int)30, (int)0));
        mainPanel.game = this;
        
        mainFrame = new JFrame(title);
        mainFrame.setBounds(0, 0, resX, resY+30);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setResizable(false);
        
        globalGraphics = mainPanel.getGraphics();
        
        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        
        stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        
        mainFrame.add(start);
        mainFrame.add(stop);
        mainFrame.setVisible(true);
        setTitle(title);
        
        spriteList = new ArrayList<Sprite>();
        
        onCreate();
    }
    
    public final String getTitle() {
        return title;
    }
    
    public final void setTitle(String title) {
        mainFrame.setTitle(title);
        this.title = title;
    }
    
    public final ArrayList<Sprite> getSpriteList() {
        return this.spriteList;
    }
    
    public final void start() {
        
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }
    
    public final void stop() {
        if (gameThread != null) {
            gameThread = null;
            running = false;
        }
    }
    
    @Override
    public void run() {
        long nanosec = System.nanoTime();
        while (gameThread != null) {
            long delay = (long)1e9 / 60;
            mainPanel.loop();
            
            for (Sprite sprite : spriteList) {
                sprite.loop();
            }
            
            while (System.nanoTime() < nanosec + delay) {
                Thread.yield();
            }
            nanosec = System.nanoTime();
        }
    }
    
    public final void addSpriteToScene(Sprite sprite) throws Exception {
        
        for (Sprite sprite2 : spriteList) {
            if (sprite2.name.equals(sprite.name)) {
                throw new Exception("Another object with the same name is already on the stage!");
            }
        }
        
        sprite.game = this;
        
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
    
    //To be overwritten
    public void onCreate() {
        
    };
}
