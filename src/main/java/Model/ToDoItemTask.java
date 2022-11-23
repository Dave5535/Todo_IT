package Model;

import Model.Person;
import Model.ToDoItem;
import SequencersPack.TodoItemIdTaskIdSequencer;

public class ToDoItemTask {

    //fields
    private int id;
    private boolean assigned;
    private ToDoItem toDoItem;
    private Person assignee;

    //constructor
    public ToDoItemTask() {
        this.id = TodoItemIdTaskIdSequencer.nextId();
        this.assigned = true;
    }
    public ToDoItemTask(ToDoItem toDoIte, Person assignee) {
        this();
        setToDoItem(toDoItem);
        setAssigned(assigned);
    }
    //methods


    //getters & setters

    public int getId() {
        return id;
    }
    public boolean isAssigned() {
        return assigned;
    }
    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    public ToDoItem getToDoItem() {
        return toDoItem;
    }
    public void setToDoItem(ToDoItem toDoItem) {
        this.toDoItem = toDoItem;
    }
    public Person getAssignee() {
        return assignee;
    }
    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return assigned;
    }

    @Override
    public String toString() {

        return "Task id : " + getId() + "  Task :" + getToDoItem() +" Assigned : "+ assigned;
    }
}// Class
