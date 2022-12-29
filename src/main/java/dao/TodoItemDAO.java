package dao;

import Model.Person;
import Model.ToDoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends BaseDao<ToDoItem> {

    ToDoItem findById(int Id);// findByid(int):ToDoItem
    Collection<ToDoItem> findAllByDoneStatus(Boolean done);
    Collection<ToDoItem> findByTitleContains(String title);
    Collection<ToDoItem> findByPersonId(int personId);
    Collection<ToDoItem> findByDeadlineBefore(LocalDate date);
    Collection<ToDoItem> findByDeadLineAfter(LocalDate date);
    void remove(int id);
    Collection<ToDoItem> findByDoneStatus(boolean item);
   void create(ToDoItem toDoItem);  //create(ToDoItem):ToDoItem
   void findByAssignee(int assignee);  //findByAssignee(int):Collection<ToDoItem>
    void update(ToDoItem toDoItem);   //update(ToDoItem):ToDoItem
    void deleteById(int id);   //deleteById(int):boolean 1/0
    Collection<ToDoItem> findByAssignee(Person person);//findByAssignee(Person):Collection<ToDoItem>
Collection<ToDoItem> findByUnAssigneeTodoItems();

}
