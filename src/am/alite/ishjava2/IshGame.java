/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.alite.ishjava2;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luka
 */
public abstract class IshGame {
    private String title;
    private JPanel mainPanel;
    private JFrame mainFrame;
    
    public IshGame() {
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        onCreate();
    }
    
    public final String getTitle() {
        return title;
    }
    
    public final void setTitle(String title) {
        this.title = title;
    }
    
    abstract void onCreate();
}
