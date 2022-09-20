package my_project.view;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;

public class KeyboardInput extends InteractiveGraphicalObject {

    private final ProgramController programController;

    public KeyboardInput(ProgramController programController, ViewController viewController) {
        this.programController = programController;
        viewController.register(this);
    }

    @Override
    public void keyReleased(int key) {
        if (key == KeyEvent.VK_ENTER) programController.send();
    }
}

