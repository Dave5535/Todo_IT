package org.example;

import java.time.LocalDate;
import java.time.Period;

public class ToDoItem {
    private static int sequencer = 0;
    //fields
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;

    private Person creator;

    //constructors
    public ToDoItem() {
        this.id = ++sequencer;
        this.done = true;
    }
    public ToDoItem(String title, String taskDescription,LocalDate deadline) {
        this();
        setTitle(title);
        setTaskDescription(taskDescription);


    }
    //methods


    public boolean isOverdue() {
        LocalDate tookTask = LocalDate.parse("2022-11-04");


        LocalDate nowTime = LocalDate.now();
        Period timeLeft = Period.between(nowTime, deadline);
        if (timeLeft.equals(0)) {
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
        return done;
    }

    @Override
    public String toString() {
        return "Mission id : " + id + " Mission : " + taskDescription + " Located in : "+ title + " Performed : " + done;
    }
}//class
