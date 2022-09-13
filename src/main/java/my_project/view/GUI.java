package my_project.view;

import my_project.control.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private Client client;
    private JPanel chatPanel;
    private JTextArea chatArea;
    private JButton sendButton;
    private JTextField userText;

    public GUI(Client client){
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendMessage(userText.getText());
            }
        });
    }

    public JPanel getPanel(){
        return chatPanel;
    }

    public void showText(String str){
        chatArea.append(str+"\n");
    }
}
