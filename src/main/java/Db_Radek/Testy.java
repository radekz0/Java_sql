package Db_Radek;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Testy extends JFrame {
    private JButton button;
    private JTextField textfield;
    private JPanel panel;
    private JLabel label;
    public String input = "as";

    Testy(){
        panel = new JPanel();
        button = new JButton("click me");
        textfield = new JTextField("", 20);
        label = new JLabel();

        this.add(panel);
        panel.add(textfield);
        panel.add(button);
        panel.add(label);


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textfield.getText();
                label.setText(input);

            }
        });

    }






    public static void main(String[] args){
        Testy test = new Testy();
        test.setSize(300,300);
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
