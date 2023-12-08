package project.test2;

import javax.swing.JFrame;
import java.io.IOException;

public class Window {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("Escape the dungeon");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
