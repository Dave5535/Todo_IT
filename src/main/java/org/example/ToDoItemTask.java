package org.example;

public class ToDoItemTask {
    private static int sequencer = 0;
    //fields
    private int id;
    private boolean assigned;
    private ToDoItem toDoItem;
    private Person assignee;

    //constructor
    public ToDoItemTask() {
        this.id = ++sequencer;
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
}// Class
