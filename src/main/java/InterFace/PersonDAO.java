package InterFace;

import org.example.Person;

import java.util.Collection;

public interface PersonDAO {
    Person persist(Person person);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void remove(int id);

}
