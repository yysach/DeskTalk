package com.GUI;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea textArea;
    public TextPanel(){

        textArea= new JTextArea();
        setLayout(new BorderLayout());

        add(new JScrollPane(textArea),BorderLayout.CENTER);

    }

    public void append(String s) {  // here we override the append function to our TextPanel
        textArea.append(s+"\n");
    }
}
