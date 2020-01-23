package gui;

import control.Command;
import control.NextPersonCommand;
import control.PrevPersonCommand;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.PersonList;
import view.PersonDisplay;
import view.PersonListDisplay;

public class SwingPersonListDisplay extends JFrame implements PersonListDisplay {
    private final PersonList personList;
    private PersonDisplay personDisplay;
    private int index = 0;
    private final HashMap<String,Command> commands;

    public SwingPersonListDisplay(PersonList personList) {
        this.commands = new HashMap<>();
        this.personList = personList;
        
        this.setTitle("Person List Display");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        
        this.getContentPane().add(personDisplay());
        personDisplay.displayPerson(personList.current());
        addCommands();
        this.getContentPane().add(toolBar(),BorderLayout.NORTH);
        this.setVisible(true);
    }


    @Override
    public void displayPrev() {
        this.personDisplay.displayPerson(personList.prev());
    }

    @Override
    public void displayNext() {
        this.personDisplay.displayPerson(personList.next());
    }

    private void addCommands() {
        this.commands.put("PrevPerson", new PrevPersonCommand(this));
        this.commands.put("NextPerson", new NextPersonCommand(this));
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener((ActionEvent e) -> {
            commands.get("PrevPerson").execute();
        });
        return button;
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener((ActionEvent e) -> {
            commands.get("NextPerson").execute();
        });
        return button;
    }

    private JPanel personDisplay() {
        SwingPersonDisplay swingPersonDisplay = new SwingPersonDisplay();
        this.personDisplay = swingPersonDisplay;
        return swingPersonDisplay;
    }
}
