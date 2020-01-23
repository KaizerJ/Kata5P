package control;

import view.PersonListDisplay;

public class PrevPersonCommand implements Command{
    private final PersonListDisplay personListDisplay;

    public PrevPersonCommand(PersonListDisplay personListDisplay) {
        this.personListDisplay = personListDisplay;
    }

    @Override
    public void execute() {
        this.personListDisplay.displayPrev();
    }
    
}
