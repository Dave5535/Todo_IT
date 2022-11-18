package InterFace;

import Model.AppUser;
import org.example.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class PersonDAOCollection implements PersonDAO{
  private List<Person> persons;
    public PersonDAOCollection(){
        persons = new ArrayList<>();
    }


    @Override
    public Person persist(Person person) {
       if (person == null)throw new IllegalArgumentException("person was null");
        if (findAll() == person)throw new IllegalArgumentException("person do already exist in memory");
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
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }
    @Override
    public void remove(int id) {
        persons.removeIf(removeItem -> removeItem.getId() == id);
    }
}
