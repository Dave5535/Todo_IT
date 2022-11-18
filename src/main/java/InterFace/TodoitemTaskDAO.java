package InterFace;

import org.example.Person;
import org.example.ToDoItemTask;

import java.util.Collection;

public interface TodoitemTaskDAO {
    ToDoItemTask persist(ToDoItemTask todoItemTask);
    ToDoItemTask findById(int id);
    Collection<ToDoItemTask> findAll();
    Collection<ToDoItemTask> findByPersonId(Person personId);
    void remove(int id);
}
