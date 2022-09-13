package my_project.model;

public class Client extends KAGO_framework.model.abitur.netz.Client {

    private String name;

    public Client(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    @Override
    public void processMessage(String pMessage) {
        //TODO react
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
                }else System.out.println("INVALID_NAME");
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
}
