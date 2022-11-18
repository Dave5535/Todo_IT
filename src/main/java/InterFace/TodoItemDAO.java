package InterFace;

import org.example.ToDoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {
    ToDoItem persist(ToDoItem todoItem);
    ToDoItem findById(int Id);
    Collection<ToDoItem> findAllByDoneStatus(Boolean done);
    Collection<ToDoItem> findByTitleContains(String title);
    Collection<ToDoItem> findByPersonId(int personId);
    Collection<ToDoItem> findByDeadlineBefore(LocalDate date);
    Collection<ToDoItem> findByDeadLineAfter(LocalDate date);
    void remove(int id);
}
