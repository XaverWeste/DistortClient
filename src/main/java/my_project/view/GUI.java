package my_project.view;

import my_project.control.Client;

import javax.swing.*;

public class GUI {

    private JPanel chatPanel;
    private JTextArea chatArea;
    private JButton sendButton;
    private JTextField userText;

    public GUI(Client client){
        sendButton.addActionListener(e -> client.sendMessage(userText.getText()));
    }

    public JPanel getPanel(){
        return chatPanel;
    }

    public void showText(String str){
        chatArea.append(str+"\n");
    }
}
