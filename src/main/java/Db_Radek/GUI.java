package Db_Radek;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JFrame frame;
    private JButton button, button2;
    private JPanel panel;
    private DbController controller;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JTextField textField;

    public String storeText(){
        String input = textField.getText();
        return input;
    }

    GUI(){
        frame = new JFrame();
        button = new JButton("All tracks.");
        button2 = new JButton("Search in tracks.");
        panel = new JPanel();
        controller = new DbController();
        textField = new JTextField("",20);
        textArea = new JTextArea(30, 30);
        textArea.setEditable(false);

        //Adding a scroll to a textArea
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(panel);
        panel.add(textField);
        panel.add(button2);
        panel.add(button);
        panel.add(scrollPane);

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String names = controller.searchNames(storeText());
                textArea.setText(names);
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getNames();
                textArea.setText(controller.getNames());
            }
        });
    }
}