package my_project.view;

import my_project.control.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JPanel chatPanel;
    private JTextArea chatArea;
    private JButton sendButton;
    private JTextField userText;
    private Client client;

    public GUI(Client client){
        this.client = client;
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send();
            }
        });
    }

    public void send(){
        if(!userText.getText().equals("")) {
            client.sendMessage(userText.getText());
            userText.setText("");
        }
    }

    public JPanel getPanel(){
        return chatPanel;
    }

    public void showText(String str){
        chatArea.append(str+"\n");
    }
}
