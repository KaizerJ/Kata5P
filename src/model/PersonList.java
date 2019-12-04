package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonList implements Iterable<Person>{
    private final List<Person> people;

    public PersonList(List<Person> list) {
        this.people = list;
    }
    
    public PersonList(){
        this.people = new ArrayList<>();
    }
    
    public boolean addPerson(Person person){
        return people.add(person);
    }
    
    public boolean addPerson(String name, String surname, String department){
        return people.add(new Person(name,surname,department));
    }
    
    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    public int size() {
        return people.size();
    }
}
