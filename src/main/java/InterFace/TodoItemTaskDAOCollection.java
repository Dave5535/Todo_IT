package InterFace;

import org.example.Person;
import org.example.ToDoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskDAOCollection implements TodoitemTaskDAO{
private List<ToDoItemTask> taskList;


    public TodoItemTaskDAOCollection(){
        taskList = new ArrayList<>();
    }
    @Override
    public ToDoItemTask persist(ToDoItemTask todoItemTask) {
       taskList.add(todoItemTask);
        return todoItemTask;
    }
    @Override
    public ToDoItemTask findById(int id) {
        for (ToDoItemTask c : taskList)
            if(id == c.getId()) return c;
        return null;
    }
    @Override
    public Collection<ToDoItemTask> findAll() {
        return taskList;
    }
    @Override
    public Collection<ToDoItemTask> findByPersonId(Person personId) {
       if (personId == null) throw new IllegalArgumentException("person id was null ");
        List<ToDoItemTask> personList = new ArrayList<>();
        for(ToDoItemTask taskList : taskList)
            if (taskList.getId()== personId.getId())
                personList.add(taskList);
        return personList;
    }
    @Override
    public void remove(int id) {
        for(ToDoItemTask taskList : taskList)
            if (taskList.getAssignee() != null && taskList.getAssignee().getId()==(id))
                taskList.setAssigned(false);
    }
}
