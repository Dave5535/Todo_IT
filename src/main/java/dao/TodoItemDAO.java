package dao;

import Model.ToDoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends BaseDao<ToDoItem> {

    ToDoItem findById(int Id);
    Collection<ToDoItem> findAllByDoneStatus(Boolean done);
    Collection<ToDoItem> findByTitleContains(String title);
    Collection<ToDoItem> findByPersonId(int personId);
    Collection<ToDoItem> findByDeadlineBefore(LocalDate date);
    Collection<ToDoItem> findByDeadLineAfter(LocalDate date);
    void remove(int id);
}
