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

    public void sendMessage(String pMessage){
        String[] m = pMessage.split(" ");

        if(m[0].equals("/setname")){
            if(m[1].matches("^[a-zA-Z]$+") && m.length == 2){
                send("SETNAME_"+m[1]);
                setName(m[1]);
            }else{
                System.out.println("INVALID_NAME");
            }

        }else if(m[0].equals("/join") && m.length == 1){
            send("JOIN");

        }else if(m[0].equals("/leave") && m.length == 1){
            send("LEAVE");

        }else if(m[0].equals("/whisper") && m.length > 2){
            String message = "WHISPER_"+m[1]+"_";
            for(int i = 2; i < m.length; i++){
                message += m[i] + " ";
            }
            send(message);

        }else{
            send("MESSAGE_" + pMessage);
        }
    }

}
