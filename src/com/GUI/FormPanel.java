package com.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel {
    private JTextField nameField;
    private JTextField occupationField;
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JList ageList;
    private JButton okBtn;

    private FormListener formListener;
    public  FormPanel(){

        Dimension dim = getPreferredSize();
        dim.width=250;
        setPreferredSize(dim);

        nameField = new JTextField(10);
        occupationField= new JTextField(10);
        nameLabel = new JLabel("Name : ");
        occupationLabel = new JLabel("Occupation : ");
        ageList= new JList();
        okBtn = new JButton("OK");


        DefaultListModel ageModel= new DefaultListModel();
        ageModel.addElement(new AgeCategory(1,"Under 18"));
        ageModel.addElement(new AgeCategory(2,"18 to 60"));
        ageModel.addElement(new AgeCategory(3,"above 60"));
        ageList.setModel(ageModel);


        ageList.setPreferredSize(new Dimension(110,110));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);



        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name= nameField.getText();
                String occupation=occupationField.getText();
                AgeCategory ageCategory = (AgeCategory) ageList.getSelectedValue();

                FormEvent ev= new FormEvent(this,name,occupation,ageCategory.getId());

                if(formListener!=null){
                    formListener.formEVentOccured(ev);
                }
            }
        });

        Border innerBorder= BorderFactory.createTitledBorder("Add Details");
        Border outerBorder= BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc= new GridBagConstraints();

        // First Row
        gc.weightx=1;
        gc.weighty=1;

        gc.gridx=0;
        gc.gridy=0;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(nameLabel,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_START;
        add(nameField,gc);

        // second Row
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.LINE_END;
        add(occupationLabel,gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.LINE_START;
        add(occupationField,gc);

        // third Row
        gc.weightx=1;
        gc.weighty=2.0;
        gc.gridx=1;
        gc.gridy=2;
        gc.anchor=GridBagConstraints.LINE_START;
        add(ageList,gc);

        // forth Row
        gc.weightx=1;
        gc.weighty=2.0;
        gc.gridx=1;
        gc.gridy=3;
        gc.anchor=GridBagConstraints.LINE_START;
        add(okBtn,gc);
        okBtn.setMnemonic(KeyEvent.VK_O); // setting shortcut for ok button event
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}

class AgeCategory{
    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String toString(){
        return text;
    }
}