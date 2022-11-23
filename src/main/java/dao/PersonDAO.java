package dao;

import Model.Person;

import java.util.Collection;

public interface PersonDAO extends BaseDao<Person> {

    Person findByEmail(String email);
Person findById(Integer id);
    void remove(int id);

}
