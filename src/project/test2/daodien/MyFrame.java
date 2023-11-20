package project.test2.daodien;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton start;
    JButton huong;
    JButton exit;
    JLabel bk;

    MyFrame() {

        this.setTitle("Escape the dungeon");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 853);
        this.setResizable(false);
        ImageIcon logo = new ImageIcon("src\\project\\test2\\imag\\logo.png");
        this.getContentPane().setBackground(Color.black);
        this.setIconImage(logo.getImage());
        ImageIcon iconBk = new ImageIcon("src\\project\\test2\\imag\\.png");
        bk = new JLabel("",iconBk,JLabel.CENTER);
        add(bk);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ImageIcon iconStart = new ImageIcon("src\\project\\test2\\imag\\imageStart.png");
        start = new JButton();
        start.setBounds(540, 100, 200, 100);
        start.setIcon(iconStart);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        bk.add(start);

        huong = new JButton();
        huong.setBounds(540, 200, 200, 100);
        huong.setText("HOW TO PLAY");
        huong.setFont(new Font("Comic Sans", Font.BOLD, 20));
        huong.setForeground(Color.red);
        huong.setBorderPainted(false);
        huong.setContentAreaFilled(false);
       bk.add(huong);

        ImageIcon iconExit = new ImageIcon("src\\project\\test2\\imag\\exit.png");
        exit = new JButton();
        exit.setBounds(540, 300, 200, 100);
        exit.setIcon(iconExit);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        bk.add(exit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {

        }
        if (e.getSource() == huong) {

        }
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
