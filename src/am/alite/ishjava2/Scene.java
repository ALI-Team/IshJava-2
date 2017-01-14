/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.alite.ishjava2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author luka
 */
public class Scene extends JPanel {

    IshGame game;

    public void loop() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (game.running) {
            try {
                for (Sprite sprite : game.getSpriteList()) {
                    if (sprite.direction == 0) {
                        g.drawImage(sprite.image, sprite.xPos, sprite.yPos, this);
                    } else {
                        /*AffineTransform xform = new AffineTransform();
                        xform.translate((int) (sprite.xPos + 0.5 + sprite.image.getWidth(this)), (int) (sprite.yPos + 0.5 + sprite.image.getHeight(this)));
                        xform.rotate(sprite.direction);
                        xform.translate(-sprite.image.getWidth(this) / 2, sprite.image.getHeight(this) / 2);
                        ((Graphics2D) g).drawImage(sprite.image, xform, null);*/
                        
                        double rotation = Math.toRadians(sprite.direction);
                        double locX = sprite.image.getWidth(this) / 2;
                        double locY = sprite.image.getHeight(this) / 2;
                        
                        AffineTransform tx = AffineTransform.getRotateInstance(rotation, locX, locY);
                        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
                        
                        ((Graphics2D) g).drawImage(op.filter((BufferedImage)sprite.image, null), sprite.xPos, sprite.yPos, null);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("No Sprite list!");
            }
        }
    }
}
