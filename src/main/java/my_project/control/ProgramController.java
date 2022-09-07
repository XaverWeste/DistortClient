package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.User;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;
    private User user;
    private String ServerIP;
    private int ServerPort;
    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        user = new User(ServerIP,ServerPort,this);

    }

    public void sendMessage(String pMessage){
        String[] m = pMessage.split(" ");

        if(m[0].equals("/setname")){    //Setname
            if(m[1].matches("^[a-zA-Z]$+") && m.length == 2){
                user.send("SETNAME_"+m[1]);
                user.setName(m[1]);
            }else{
                System.out.println("INVALID_NAME");
            }

        }else if(m[0].equals("/join") && m.length == 1){    //Join
            user.send("JOIN");

        }else if(m[0].equals("/leave") && m.length == 1){    //Leave
            user.send("LEAVE");

        }else if(m[0].equals("/whisper") && m.length > 2){   //Whisper
            String message = "WHISPER_"+m[1]+"_";
            for(int i = 2; i < m.length; i++){
                message += m[i] + " ";
            }
            user.send(message);

        }else{   // Message
            user.send("MESSAGE_" + pMessage);
        }
    }

    public void processMessage(String pMessage){
        System.out.println(pMessage);
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }
}
