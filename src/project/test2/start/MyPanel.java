package project.test2.start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class MyPanel extends JPanel implements ActionListener, KeyListener {
    int width;
    int height;
    int tileSize = 25;


    private static class tile {
        int x;
        int y;

        public tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    tile player;

    tile wolf;

    static class Node {
        int x, y, direction;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.direction = 0;
        }
    }

    Timer timer;
    boolean gameOver = false;
    Stack<Node> stack;
    private final int[][] matrix = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    boolean[][] visited;
    int moved = 0;
    Stack<Node> newStack;
    Image loli;
    Image virus;
    Image wall;
    Image floor;
    Image water;
    Image door;
    public void inputDataImage() {
        loli = new ImageIcon("src\\project\\test2\\imag\\loli.png").getImage();
        virus = new ImageIcon("src\\project\\test2\\imag\\quai.png").getImage();
        wall = new ImageIcon("src\\project\\test2\\imag").getImage();
        floor = new ImageIcon("src\\project\\test2\\imag").getImage();
        water = new ImageIcon("src\\project\\test2\\imag").getImage();
        door = new ImageIcon("src\\project\\test2\\imag").getImage();
    }

    public MyPanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.white);
        wolf = new tile(1, 11);
        player = new tile(1, 1);

        inputDataImage();

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(1000, this);
        timer.start();
    }

    public void moveGhost() {
        if (wolf.x == player.x && wolf.y == player.y) {
            gameOver = true;
            return;
        }
        if (moved == 0 || moved == 1) {
            findPlayer();
            newStack = new Stack<>();
            while (!stack.isEmpty()) {
                newStack.push(stack.pop());
            }
            moved = 2;
        }
    }

    public void findPlayer() {
        visited = new boolean[matrix.length][matrix[0].length];
        stack = new Stack<>();
        stack.push(new Node(wolf.x, wolf.y));
        Node temp;
        int x;
        int y;
        while (!stack.isEmpty()) {
            temp = stack.peek();
            x = temp.x;
            y = temp.y;
            int dir = temp.direction;
            temp.direction += 1;
            stack.pop();
            stack.push(temp);
            if (x == player.x && y == player.y) {
                return;
            }
            if (dir == 0) {
                if (x - 1 > 0 && matrix[x - 1][y] == 0 && !visited[x - 1][y]) {
                    Node temp1 = new Node(x - 1, y);
                    visited[x - 1][y] = true;
                    stack.push(temp1);
                }
            } else if (dir == 1) {
                if (y - 1 > 0 && matrix[x][y - 1] == 0 && !visited[x][y - 1]) {
                    Node temp1 = new Node(x, y - 1);
                    visited[x][y - 1] = true;
                    stack.push(temp1);
                }
            } else if (dir == 2) {
                if (x + 1 < matrix.length && matrix[x + 1][y] == 0 && !visited[x + 1][y]) {
                    Node temp1 = new Node(x + 1, y);
                    visited[x + 1][y] = true;
                    stack.push(temp1);
                }
            } else if (dir == 3) {
                if (y + 1 < matrix[0].length && matrix[x][y + 1] == 0 && !visited[x][y + 1]) {
                    Node temp1 = new Node(x, y + 1);
                    visited[x][y + 1] = true;
                    stack.push(temp1);
                }
            } else {
                visited[x][y] = false;
                stack.pop();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                Image image = switch (matrix[i][j]) {
//                    case 1 -> wall;
//                    case -1 -> water;
//                    default -> floor;
//                };
//                g.drawImage(image,j * tileSize + 100, i * tileSize + 100, null);
//            }
//        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Color color;
                switch (matrix[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case -1:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(25 * j+100, 25 * i+100, 25, 25);
                g.setColor(Color.black);
                g.drawRect(25 * j+100, 25 * i+100, 25, 25);
            }
        }

        g.setColor(Color.blue);
        g.fillRect(player.y * tileSize + 100, player.x * tileSize + 100, tileSize, tileSize);

        if (gameOver) return;
        moveGhost();
        newStack.pop();
        Node node = newStack.peek();
        g.setColor(Color.white);
        g.fillRect(wolf.y * tileSize + 100, wolf.x * tileSize + 100, tileSize, tileSize);

        wolf.x = node.x;
        wolf.y = node.y;
        g.setColor(Color.red);
        g.fillRect(wolf.y * tileSize + 100, wolf.x * tileSize + 100, tileSize, tileSize);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        switch (e.getKeyChar()) {
//            case 'a' : if (matrix[player.x][player.y-1]!=1) player.y-=1; break;
//            case 'd' : if (matrix[player.x][player.y+1]!=1) player.y+=1; break;
//            case 's' : if (matrix[player.x+1][player.y]!=1) player.x+=1; break;
//            case 'w' : if (matrix[player.x-1][player.y]!=1) player.x-=1; break;
//        }
//
//        moved = 1;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> {
                if (matrix[player.x][player.y - 1] != 1) player.y -= 1;
            }
            case 'd' -> {
                if (matrix[player.x][player.y + 1] != 1) player.y += 1;
            }
            case 's' -> {
                if (matrix[player.x + 1][player.y] != 1) player.x += 1;
            }
            case 'w' -> {
                if (matrix[player.x - 1][player.y] != 1) player.x -= 1;
            }
        }
        if (player.x == matrix.length-2&&player.y==matrix[0].length-2) gameOver= true;
        moved = 1;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            timer.stop();
        }
        repaint();
    }

}
