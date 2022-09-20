package my_project.control;

import my_project.view.GUI;

public class Client extends KAGO_framework.model.abitur.netz.Client {

    private String name;
    private GUI gui;
    private String lastWhisper;

    public Client() {
        super("10.17.128.78", 6969);
        System.out.println(isConnected());
    }

    @Override
    public void processMessage(String pMessage) {
        if(gui!=null) {
            String[] args=pMessage.split("_");
            if(args[0].equals("MESSAGE")&&args.length>2){
                gui.showText(args[1]+" : "+args[2]);
            }else if(args[0].equals("DM")&&args.length>3) {
                if(args[1].equals("RECIEVED")) {
                    gui.showText("Msg from " + args[2] + " : " + args[3]);
                }else if(args[1].equals("SENT")){
                    gui.showText("Msg sent to " + lastWhisper);
                }
            }else if(args[0].equals("CHANGED-NAME")){
                gui.showText("System: " + args[1] + " changed his name to " + args[2] + "!");
            }else if(args[0].equals("ERR")){
                switch (args[1]) {
                    case "ALREADY-JOINED" -> gui.showText("System: You are already in the room!");
                    case "NOT-CONNECTED", "NOT-IN-ROOM" -> gui.showText("System: You are not in the room!");
                    case "USER-NOT-FOUND" -> gui.showText("System: User not found!");
                    case "DUPLICATE-NAME" -> gui.showText("System: Duplicate name!");
                    case "INVALID-INPUT" -> gui.showText("System: Invalid command");
                }
            }else if(args[0].equals("NAME-SET")){
                gui.showText("System: Name set to " + name);
            }else if(args[0].equals("JOINED")){
                gui.showText("System: " + args[1] + " joined the chat!");
            }else if(args[0].equals("LEFT")){
                gui.showText("System: " + args[1] + " left");
            }
        }else System.err.println("GUI ist null");
    }

    public void setName(String name) {
        this.name = name;
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
            case "/whisper" -> {
                if(m.length>2) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 2; i < m.length; i++) sb.append(m[i]).append(" ");
                    lastWhisper = m[1] + ": " + sb;
                    send("WHISPER_" + m[1] + "_" + sb);
                }
            }
            default -> send("MESSAGE_" + message);
        }
    }

    public void setGui(GUI gui){
        this.gui=gui;
    }
}
