package project.entity;



import project.test2.GamePanel;

import java.util.Stack;

public class MonkeyDemon extends Entity {
    public MonkeyDemon(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;
//        getImage();
    }
//    public void getImage() {
//        try {
//            up1 = ImageIO.read(new File("src/res/player/up1.png"));
//            up2 = ImageIO.read(new File("src/res/player/up2.png"));
//            down1 = ImageIO.read(new File("src/res/player/down1.png"));
//            down2 = ImageIO.read(new File("src/res/player/down2.png"));
//            left1 = ImageIO.read(new File("src/res/player/left1.png"));
//            left2 = ImageIO.read(new File("src/res/player/left2.png"));
//            right1 = ImageIO.read(new File("src/res/player/right1.png"));
//            right2 = ImageIO.read(new File("src/res/player/right2.png"));
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void setAction() {
        usingDfs();
//        stack.pop();
    }
    static class Node {
        int x, y, direction;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.direction = 0;
        }
    }
    Stack<Node> stack;
    boolean[][] visited;
    public void usingDfs() {
        visited = new boolean[gp.tileManager.map.length][gp.tileManager.map[0].length];
        stack = new Stack<>();
        stack.push(new Node(worldX/48, worldY/48));
        Node temp;
        int x;
        int y;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            x = temp.x;
            y = temp.y;
            int dir = temp.direction;
            temp.direction += 1;
            stack.push(temp);
            if (x == gp.player.worldX/48 && y == gp.player.worldY/48) {
                return;
            }
            if (dir == 0) {
                if (x - 1 > 0 && gp.tileManager.map[x - 1][y] == 0 && !visited[x - 1][y]) {
                    Node temp1 = new Node(x - 1, y);
                    visited[x - 1][y] = true;
                    stack.push(temp1);
                }
            } else if (dir == 1) {
                if (y - 1 > 0 && gp.tileManager.map[x][y - 1] == 0 && !visited[x][y - 1]) {
                    Node temp1 = new Node(x, y - 1);
                    visited[x][y - 1] = true;
                    stack.push(temp1);
                }
            } else if (dir == 2) {
                if (x + 1 < gp.tileManager.map.length && gp.tileManager.map[x + 1][y] == 0 && !visited[x + 1][y]) {
                    Node temp1 = new Node(x + 1, y);
                    visited[x + 1][y] = true;
                    stack.push(temp1);
                }
            } else if (dir == 3) {
                if (y + 1 < gp.tileManager.map[0].length && gp.tileManager.map[x][y + 1] == 0 && !visited[x][y + 1]) {
                    Node temp1 = new Node(x, y + 1);
                    visited[x][y + 1] = true;
                    stack.push(temp1);
                }
            } else {
                stack.pop();
            }
        }
    }
}
