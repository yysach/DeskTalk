package com.GUI;

import javax.swing.*;


public class App {

    public static void main(String argv[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
