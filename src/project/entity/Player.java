package project.entity;

import project.test2.GamePanel;
import project.test2.KeyHandler;

//import javax.swing.*;
import javax.imageio.ImageIO;
//import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2;
        screenY = gp.screenHeight / 2;

        setDefaultValues();
//        getPlayerImage();
//        direction="down";
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 14;
        worldY = gp.tileSize * 4;
        speed = 1;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("src/res/player/up1.png"));
            up2 = ImageIO.read(new File("src/res/player/up2.png"));
            down1 = ImageIO.read(new File("src/res/player/down1.png"));
            down2 = ImageIO.read(new File("src/res/player/down2.png"));
            left1 = ImageIO.read(new File("src/res/player/left1.png"));
            left2 = ImageIO.read(new File("src/res/player/left2.png"));
            right1 = ImageIO.read(new File("src/res/player/right1.png"));
            right2 = ImageIO.read(new File("src/res/player/right2.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
//                direction = "up";
                worldY -= speed;
//                System.out.println("check");

            }
            else if (keyH.downPressed) {
//                direction = "down";
                worldY += speed;
//                System.out.println("check");

            }
            else if (keyH.leftPressed) {
//                direction = "left";
                worldX -= speed;
            }
            else if (keyH.rightPressed) {
//                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
        }
        if (spriteCounter > 10) {
            if (spriteNum == 1) spriteNum = 2;
            else spriteNum = 1;
            spriteCounter = 0;
        }
    }

        public void draw (Graphics2D g2d){
            g2d.setColor(Color.blue);
            g2d.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);

//        BufferedImage image = null;
//        Image image = null;
//        switch (direction) {
//            case "up" :
//                if (spriteNum == 1) {
//                    image = up1;
//                }else image = up2;
//                break;
//            case "down" :
//                if (spriteNum == 1) {
//                    image = down1;
//                }else image = down2;
//                break;
//            case "left" :
//                if (spriteNum == 1) {
//                    image = left1;
//                }else image = left2;
//                break;
//            case "right" :
//                if (spriteNum == 1) {
//                    image = right1;
//                }else image = right2;
//                break;
//        };
//        g2d.drawImage(image, x,y,gp.tileSize, gp.tileSize, null);
        }
    }
