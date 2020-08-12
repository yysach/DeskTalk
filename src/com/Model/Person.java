package com.Model;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID=-19808980809809L;

    private static  int count=1;
    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;

    public Person(String name, String occupation, AgeCategory ageCategory) {

        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;

        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }
}
