package com.GUI;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int ageCategory;

    public FormEvent(Object source) {
        super(source);

    }

    public FormEvent(Object source, String name, String occupation,int ageCategory){

        super(source);
        this.name=name;
        this.occupation=occupation;
        this.ageCategory=ageCategory;


    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }
}
