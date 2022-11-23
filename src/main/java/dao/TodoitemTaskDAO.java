package dao;

import Model.Person;
import Model.ToDoItemTask;

import java.util.Collection;

public interface TodoitemTaskDAO extends BaseDao<ToDoItemTask>{

    ToDoItemTask findById(int id);

    Collection<ToDoItemTask> findByPersonId(Person personId);
    void remove(int id);
}
