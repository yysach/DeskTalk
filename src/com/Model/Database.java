package com.Model;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.*;

public class Database {

    private List<Person> people;
    private String content="";

    public Database() {
        this.people = new ArrayList<>();

    }

    public void addPeople(Person person){
        people.add(person);
    }

    public List<Person> getPeople(){
        return people;
    }

    public void passToClient() throws IOException {

        ObjectServer objectServer = new ObjectServer();

        ObjectOutputStream oos= new ObjectOutputStream(objectServer.getSocket().getOutputStream());

        Person[] persons = people.toArray(new Person[people.size()]);
        oos.writeObject(persons);

        oos.close();

    }

    public String getFromClient() throws IOException{

        ObjectClient objectClient = new ObjectClient();

        ObjectInputStream ois = new ObjectInputStream(objectClient.getSocket().getInputStream());

        try {
            Person[] persons = (Person[])(ois.readObject());
            people.clear();
            people.addAll(Arrays.asList(persons));
            ListIterator<Person> listIterator = people.listIterator();
            while (listIterator.hasNext()){
                Person p=listIterator.next();
                this.content+=p.getId()+" : "+p.getName()+" : "+p.getOccupation()+" : "+p.getAgeCategory()+"\n";
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
        return this.content;

    }
}
