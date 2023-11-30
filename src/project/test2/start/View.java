package project.test2.start;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private int[][] matrix = {
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

    public View() {
        setSize(1280, 853);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(100, 100);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                Color color;
//                switch (matrix[i][j]) {
//                    case 1:
//                        color = Color.BLACK;
//                        break;
//                    case -1:
//                        color = Color.RED;
//                        break;
//                    default:
//                        color = Color.WHITE;
//                }
//                g.setColor(color);
//                g.fillRect(50 * j, 50 * i, 50, 50);
//                g.setColor(Color.black);
//                g.drawRect(50 * j, 50 * i, 50, 50);
//            }
//        }
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                View view = new View();
//                view.setVisible(view.rootPaneCheckingEnabled);
//                view.setResizable(false);
//                view.setLocationRelativeTo(null);
//            }
//        });
        new View();
    }
}
