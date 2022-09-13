package my_project.control;

import my_project.view.GUI;

public class Client extends KAGO_framework.model.abitur.netz.Client {

    private String name;
    private GUI gui;

    public Client(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    @Override
    public void processMessage(String pMessage) {
        if(gui!=null) {
            String[] args=pMessage.split("_");
            if(args[0].equals("MESSAGE")&&args.length>2){
                gui.showText(args[1]+" : "+args[2]);
            }else if(args[0].equals("DM")&&args.length>3){
                gui.showText(args[2]+" : "+args[3]);
            }
        }else System.err.println("GUI ist null");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void sendMessage(String message){
        String[] m = message.split(" ");
        switch(m[0]) {
            case "/setname" -> {
                if (m[1].matches("^[a-zA-Z]+$") && m.length == 2) {
                    send("SETNAME_" + m[1]);
                    setName(m[1]);
                }else System.err.println("INVALID_NAME");
            }
            case "/join" -> send("JOIN");
            case "/leave" -> send("LEAVE");
            case "/wisper" -> {
                if(m.length>2) {
                    StringBuilder sb = new StringBuilder("WHISPER_" + m[1] + "_");
                    for (int i = 2; i < m.length; i++) sb.append(m[i]).append(" ");
                    send(sb.toString());
                }
            }
            default -> send("MESSAGE_" + message);
        }
    }

    public void setGui(GUI gui){
        this.gui=gui;
    }
}