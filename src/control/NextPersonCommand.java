package control;

import view.PersonListDisplay;

public class NextPersonCommand implements Command{
    private final PersonListDisplay personListDisplay;

    public NextPersonCommand(PersonListDisplay personListDisplay) {
        this.personListDisplay = personListDisplay;
    }

    @Override
    public void execute() {
        this.personListDisplay.displayNext();
    }
    
}
