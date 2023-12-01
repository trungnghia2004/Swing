package project.test;

import javax.swing.JFrame;

public class MyFrame {
    public MyFrame() {
        int width = 500;
        int height = 500;

        JFrame frame = new JFrame();
        frame.setResizable(true);
        frame.setSize(width, height);



        MyPanel panel = new MyPanel(width, height);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

//    public static void main(String[] args) {
//        new MyFrame();
//    }
}
