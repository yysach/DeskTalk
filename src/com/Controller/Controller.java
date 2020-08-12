package com.Controller;

import com.GUI.FormEvent;
import com.Model.AgeCategory;
import com.Model.Database;
import com.Model.Person;
import jdk.jshell.PersistentSnippet;

import java.io.File;
import java.io.IOException;

public class Controller {

    Database db;

    public Controller() {
        db= new Database();
    }

    public  void addPeople(FormEvent ev){
        String name= ev.getName();
        String occupation= ev.getOccupation();
        int ageCategoryId = ev.getAgeCategory();
        AgeCategory ageCategory;
        switch (ageCategoryId){
            case 1:
                ageCategory= AgeCategory.child;
                break;
            case 2:
                ageCategory= AgeCategory.adult;
                break;
            case 3:
                ageCategory= AgeCategory.senior;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ageCategoryId);
        }
        Person person = new Person(name,occupation,ageCategory);

        db.addPeople(person);

    }

   // public void saveToFile(File file) throws IOException{
     //   db.saveToFile(file);
    //}

    //public String loadFromFile(File file) throws  IOException{
      //  return db.loadFromFile(file);
    //}

    public void passToClient() throws IOException {
        db.passToClient();
    }

    public String getFromClient() throws IOException {

        return db.getFromClient();
    }
}
