package Db_Radek;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private JFrame frame;
    private JButton button;
    private JPanel panel;
    private DbController controller;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    GUI(){
        frame = new JFrame();
        button = new JButton("Track Names.");
        panel = new JPanel();
        controller = new DbController();
        textArea = new JTextArea(30, 30);
        textArea.setEditable(false);
        //Adding a scroll to a textArea
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(panel);
        panel.add(button);
        panel.add(scrollPane);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getNames();
                textArea.setText(controller.getNames());
            }
        });
    }
}
