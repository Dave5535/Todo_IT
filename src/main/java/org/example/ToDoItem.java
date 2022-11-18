package org.example;

import SequencersPack.TodoItemIdSequencer;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class ToDoItem {

    //fields
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;

    private Person creator;

    //constructors
    public ToDoItem() {
        this.id = TodoItemIdSequencer.nextId();
        this.done = true;
    }
    public ToDoItem(String title, String taskDescription,LocalDate deadline) {
        this();
        setTitle(title);
        setTaskDescription(taskDescription);
setDeadline(deadline);

    }
    //methods


    public boolean isOverdue() {

        LocalDate nowTime = LocalDate.now();
        Period timeLeft = Period.between(nowTime, deadline);
        if (nowTime.compareTo(deadline)<0) {
            System.out.println(timeLeft);
            return true;
        } else {
            System.out.print(" Times up deadline was: " + deadline + " Task completed:" + taskDescription +" ");
        }
        return false;
    }//isOverdue

    //getters & setters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String item) {
        this.title = item;
    }
    //
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
    public void setDeadline(LocalDate deadline) {
        if (deadline == null) throw new IllegalArgumentException("Deadline can't be null.");
        this.deadline = deadline;
    }
    public boolean done() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public Person getCreator() {
        return creator;
    }
    public void setCreator(Person creator) {
        if (creator == null) throw new IllegalArgumentException("Username can't be null.");
        this.creator = creator;
        this.done = false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) obj;
        return id == toDoItem.id && Objects.equals(taskDescription, toDoItem.taskDescription)&& Objects.equals(title, toDoItem.title);
    }
    @Override
    public String toString() {
        return "Task id : " + id + " Task : " + taskDescription + " Task title : "+ title + " Performed : " + done;
    }

}//class
