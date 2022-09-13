package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Client;

public class ProgramController {

    private ViewController viewController;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new Client("", 0);

    }

    public void updateProgram(double dt){

    }
}
