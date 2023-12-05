package project.entity;

//import java.awt.*;


import project.test2.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX;
    public int worldY;
    public int speed;
    public String direction;
    public int spriteCounter =0;
    public int spriteNum =1;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public Rectangle solidArea = new Rectangle(0, 0,48, 48);
    public boolean collisionOn;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.tileSize < gp.player.screenX + gp.player.worldX
                && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
        {
            g2.setColor(Color.red);
            g2.fillRect(screenX, screenY, 48, 48);
        }
    }
    public void setAction() {

    }
    public void update(){
        setAction();
        collisionOn = false;
        gp.collisionChecker.checkTile(this);
        if (!collisionOn) {
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }

        }
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) spriteNum = 2;
            else spriteNum = 1;
            spriteCounter = 0;
        }
    }
}
