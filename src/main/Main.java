package main;

import dbpersistance.DBPersonLoader;
import gui.SwingPersonListDisplay;
import java.util.Iterator;
import model.Person;
import persistance.PersonLoader;

public class Main {

    public static void main(String[] args) {
        PersonLoader loader = new DBPersonLoader();
        new SwingPersonListDisplay(loader.query());
    }
    
}
