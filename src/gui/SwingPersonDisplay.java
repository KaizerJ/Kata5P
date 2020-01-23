package gui;

import java.awt.Label;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.Person;
import view.PersonDisplay;

class SwingPersonDisplay extends JPanel implements PersonDisplay {
    private Person person;

    public SwingPersonDisplay() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void displayPerson(Person person) {
        this.person = person;
        if(person == null) return;
        this.removeAll();
        this.add(new Label("Name: " + this.person.getName()));
        this.add(new Label("Last Name: " + this.person.getLastName()));
        this.add(new Label("Department: " + this.person.getDepartment()));
        this.updateUI();
    }

    /*@Override
    public void hidePerson() {
        this.getParent().remove(this);
    }*/
}
