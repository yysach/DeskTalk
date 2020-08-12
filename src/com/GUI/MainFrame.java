package com.GUI;

import com.Controller.Controller;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;
    private Controller controller;
    private JFileChooser fileChooser;
    public MainFrame(){

        super("GUI Project");
        setLayout(new BorderLayout());

        textPanel= new TextPanel();
        toolBar= new ToolBar();
        formPanel= new FormPanel();
        controller = new Controller();
        fileChooser = new JFileChooser();
        toolBar.setStringListener(new StringListener(){  // here we are doing so in order to have loosely coupled classes
            // we want our Main Frame , a controller of every thing that's why every listening event should go via Main Frame
            // Toolbar and TextPanel should not communicate with each other without taking MainFrame into account.
            @Override
            public void stringEmittedIn() {


                try {
                    String str=controller.getFromClient();
                    textPanel.append(str);

                } catch (IOException e) {
                    e.printStackTrace();
                }


//                if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION){
//                    try {
//                        String str=controller.loadFromFile(fileChooser.getSelectedFile());
//                        JOptionPane.showMessageDialog(MainFrame.this,"Do you want to import Data","Confirmation",JOptionPane.OK_CANCEL_OPTION);
//
//                        textPanel.append(str);
//                    } catch (IOException e) {
//                        JOptionPane.showMessageDialog(MainFrame.this,"Couldn't load data from file ","Error !",JOptionPane.ERROR_MESSAGE);
//                    }
//
//                }
            }
            @Override
            public void stringEmittedOut(){

                try {
                    controller.passToClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
//
//                    if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
//
//                        try {
//                            controller.saveToFile(fileChooser.getSelectedFile());
//                        } catch (IOException e) {
//                            JOptionPane.showMessageDialog(MainFrame.this,"Couldn't save the content to file ","Error !",JOptionPane.ERROR_MESSAGE);
//                        }
//                    }
//
//                }
            }
        });


        formPanel.setFormListener(new FormListener(){
            @Override
            public void formEVentOccured(FormEvent ev) {

                textPanel.append(ev.getName()+" : "+ev.getOccupation()+" : "+ev.getAgeCategory());

                controller.addPeople(ev); // adding to database through controller
            }
        });

        add(formPanel,BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(textPanel,BorderLayout.CENTER);


        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
