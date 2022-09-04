package my_project.model;

import KAGO_framework.model.abitur.netz.Client;
import my_project.control.ProgramController;

public class User extends Client {

    private ProgramController programController;
    private String name;

    public User(String pServerIP, int pServerPort, ProgramController programController) {
        super(pServerIP, pServerPort);
        this.programController = programController;
    }

    @Override
    public void processMessage(String pMessage) {
        programController.processMessage(pMessage);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
