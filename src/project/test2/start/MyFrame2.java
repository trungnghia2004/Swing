package project.test2.start;

import javax.swing.*;

public class MyFrame2 {
    public static void main(String[] args) {
        int width = 1280;
        int height = 853;

       JFrame frame = new JFrame("escape the dungeon");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(width, height);


        MyPanel panel = new MyPanel(width, height);
        frame.add(panel);
       frame.pack();
        frame.setVisible(true);
        frame.requestFocus();
    }

}
