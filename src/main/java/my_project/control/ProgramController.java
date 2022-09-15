package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.GUI;

import javax.swing.*;

public class ProgramController {

    public ProgramController(ViewController viewController){

    }

    public void startProgram() {
        System.out.println("abc");
        Client c = new Client("10.17.128.71", 6969);
        JFrame myFrame = new JFrame("Distort");
        GUI gui = new GUI(c);
        c.setGui(gui);
        myFrame.setBounds(400,200,1000,800);
        myFrame.setContentPane(gui.getPanel());
        myFrame.setVisible(true);
    }

    public void updateProgram(double dt){

    }
}
