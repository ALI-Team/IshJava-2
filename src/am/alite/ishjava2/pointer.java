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
public class pointer extends Sprite {
    
    public pointer(String name, String imgPath, int xPos, int yPos) throws IOException, Exception {
        super(name, imgPath, xPos, yPos);
    }
    
    @Override
    public final void loop() {
        this.pointTowardsSprite("box");
    }
}
