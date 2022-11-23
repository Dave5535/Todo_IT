package dao;

import Model.Person;
import SequencersPack.PersonIdSequencer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDAO{
  private List<Person> persons;
 public static PersonDAOCollection instance;
    public PersonDAOCollection(){
        persons = new ArrayList<>();
    }
public static PersonDAOCollection getInstance(){
        if(instance == null) instance = new PersonDAOCollection();
        return instance;

}

    @Override
    public Person persist(Person person) {
       if (person == null)throw new IllegalArgumentException("person was null");
        if (findAll() == person)throw new IllegalArgumentException("person do already exist in memory");
       person.setId(PersonIdSequencer.nextId());
        persons.add(person);
        return person;
    }
    @Override
    public Person findByEmail(String email) {
        if (email == null) throw new IllegalArgumentException("ssn was null");
        for (Person person : persons)
            if (person.getEmail().equalsIgnoreCase(email)) return person;
        return null;
    }

    @Override
    public Person findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
          for (Person person : persons)
              if (person.getId() == person.getId()) return person;
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }
    @Override
    public void remove(int id) {
        persons.removeIf(removeItem -> removeItem.getId() == id);
    }
}
