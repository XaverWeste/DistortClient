package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.GUI;

import javax.swing.*;
import my_project.model.Client;

public class ProgramController {

    private JFrame myFrame;
    private GUI gui;
    private Client c;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */

    public ProgramController(ViewController viewController){

    }

    public void startProgram() {
        c=new Client("",0);
        myFrame = new JFrame("Distort");
        gui = new GUI();
        myFrame.setBounds(400,200,1000,800);
        myFrame.setContentPane(gui.getPanel());
        myFrame.setVisible(true);
    }

    public void updateProgram(double dt){

    }
}
