package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener{
    private JButton importBtn;
    private JButton exportBtn;

    private StringListener stringListener;

    public ToolBar(){
        setLayout(new FlowLayout());
        importBtn =new JButton("Import");
        exportBtn= new JButton("Export");

        importBtn.addActionListener( this);
        exportBtn.addActionListener(this);

        importBtn.setBackground(Color.WHITE);
        exportBtn.setBackground(Color.WHITE);

        add(exportBtn,FlowLayout.LEFT);
        add(importBtn,FlowLayout.LEFT);

    }

    public void setStringListener(StringListener stringListener) {
        this.stringListener = stringListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton) actionEvent.getSource();

        if(clicked==importBtn){
            stringListener.stringEmittedIn();
        }else if(clicked== exportBtn){
            stringListener.stringEmittedOut();
        }


    }
}
