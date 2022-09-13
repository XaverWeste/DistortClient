package my_project.view;

import javax.swing.*;

public class GUI {
    private JPanel chatPanel;
    private JTextField userText;
    private JButton sendButton;
    private JTextArea textArea1;

    public GUI(){
    }

    public JPanel getPanel(){
        return chatPanel;
    }
}
