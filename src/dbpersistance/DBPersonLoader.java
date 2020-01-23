package dbpersistance;

import model.PersonList;
import persistance.PersonLoader;

public class DBPersonLoader implements PersonLoader {

    @Override
    public PersonList query() {
        //STUB CODE
        PersonList personList = new PersonList();
        personList.addPerson("Horacio", "Martinez", "IT");
        personList.addPerson("Facundo", "Hernandez", "Maraaaaaaaaaaaketing");
        personList.addPerson("Eustaquio", "Molina", "CEO");
        //STUB
        return personList;
    }
    
}
