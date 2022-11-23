package dao;

import Model.ToDoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements TodoItemDAO {
    private List<ToDoItem> items;
public static TodoItemDAOCollection instance;
    public TodoItemDAOCollection() {
        items = new ArrayList<>();
    }

    public static TodoItemDAOCollection getInstance(){
        if(instance == null) instance = new TodoItemDAOCollection();
        return instance;
    }
    @Override
    public ToDoItem persist(ToDoItem todoItem) {
        items.add(todoItem);
        return todoItem;
    }



    @Override
    public ToDoItem findById(int id) {
        for (ToDoItem task : items)
            if (task.getId()==id) return task;
        return null;
    }
    @Override
    public Collection<ToDoItem> findAllByDoneStatus(Boolean done) {
        if (done == null) throw new IllegalArgumentException("done was null");
       List<ToDoItem> findStatus = new ArrayList<>();
        for (ToDoItem task : items) {
            if (task.done() && task.done() == done)
                findStatus.add(task);
        }
        return findStatus;
    }
    @Override
    public Collection<ToDoItem> findByTitleContains(String title) {
        if (title == null) throw new IllegalArgumentException("title was null");
        List<ToDoItem> containTitle = new ArrayList<>();
        for (ToDoItem toDoItem : items)
            if (toDoItem.getTitle().equalsIgnoreCase(title))
                containTitle.add(toDoItem);
        return containTitle;
    }
    @Override
    public Collection<ToDoItem> findByPersonId(int personId) {
       List<ToDoItem> personList = new ArrayList<>();
        for (ToDoItem person : items)
            if (person.getId() == personId)
                personList.add(person);
        return personList;
    }
    @Override
    public Collection<ToDoItem> findByDeadlineBefore(LocalDate date) {
      List<ToDoItem> deadLineBefore = new ArrayList<>();
        for (ToDoItem timeLeft : items){
LocalDate findDate  = timeLeft.getDeadline();
            if (findDate.isBefore(date) || findDate.equals(date))
                deadLineBefore.add(timeLeft);
        }
        return deadLineBefore;
    }
    @Override
    public Collection<ToDoItem> findByDeadLineAfter(LocalDate date) {
        List<ToDoItem> deadLineAfter = new ArrayList<>();
        for (ToDoItem time : items){
            LocalDate findDate  = time.getDeadline();
            if (findDate.isAfter(date) || findDate.equals(date))
                deadLineAfter.add(time);
        }
        return deadLineAfter;
    }
    @Override
    public void remove(int id) {
        items.removeIf(removeItem -> removeItem.getId() == id);
    }



    @Override
    public Collection<ToDoItem> findAll() {
        return items;
    }
}
