package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Person;
import model.PersonList;
import view.PersonDisplay;
import view.PersonListDisplay;

public class SwingPersonListDisplay extends JFrame implements PersonListDisplay {
    private final PersonList personList;
    private final List<PersonDisplay> personDisplays;

    public SwingPersonListDisplay(PersonList personList) {
        this.personList = personList;
        personDisplays = new ArrayList<>();
    }

    @Override
    public void loadList() {
        for (Person person : personList) {
            personDisplays.add(new SwingPersonDisplay(person));
        }
    }

    @Override
    public void displayNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayPrev() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
