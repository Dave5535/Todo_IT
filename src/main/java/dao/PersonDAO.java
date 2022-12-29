package dao;

import Model.AppUser;
import Model.Person;

public interface PersonDAO extends BaseDao<Person> {

    Person findByEmail(String email);
Person findById(Integer id);
    void remove(int id);

    void create(Person person); // create(Person):Person

    void findByName(String name);  //findByName(String):Collection<Person>
    void update(Person person);  //update(Person):Person
    void deleteById(int id);  // deleteByid(int):boolean
    Person findById(int id);


    /*
    findAll():Collection<Person>
    findById(int):Person
     */
}
