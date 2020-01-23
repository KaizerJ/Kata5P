package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonList implements Iterable<Person>{
    private final List<Person> people;
    private int index = 0;

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
    
    public Person current(){
        if(people.size() > 0){
            return people.get(index);
        }
        return null;
    }
    
    public Person next(){
        if(people.size() > 0){
            index = ++index == people.size() ? 0 : index++;
            return people.get(index);
        }
        return null;
    }
    
    public Person prev(){
        if(people.size() > 0){
            index = --index < 0 ? people.size() - 1 : index--;
            return people.get(index);
        }
        return null;
    }
}
