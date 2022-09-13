package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.User;

public class ProgramController {

    private ViewController viewController;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new User("", 0);

    }

    public void updateProgram(double dt){

    }
}
