package project.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing extends JFrame {
    private JTextField textField1;
    private JButton cilckMeButton;
    private JPanel SwingPanel;
    private JLabel helloLabel;

    public swing() {
        setContentPane(SwingPanel);
        setTitle("hello");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,500);
        setLocationRelativeTo(null);
        setVisible(true);
        cilckMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                JOptionPane.showMessageDialog(swing.this,"Hello: " +  name);
            }
        });
    }

    public static void main(String[] args) {
        new swing();
    }

}
