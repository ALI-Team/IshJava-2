/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.alite.ishjava2;

import java.io.IOException;

/**
 *
 * @author luka
 */
public class box extends Sprite {
    
    public int counter = 100;
    
    public box(String name, String imgPath, int xPos, int yPos) throws IOException, Exception {
        super(name, imgPath, xPos, yPos);
    }
    
    @Override
    public final void loop() {
        counter--;
        
        if (counter == 0) {
            counter = 100;
            this.xPos = randomWithRange(0, 1280);
            this.yPos = randomWithRange(0, 720);
        }
    }
    
    public static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
