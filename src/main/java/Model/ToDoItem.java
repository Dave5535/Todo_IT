package Model;

import SequencersPack.TodoItemIdSequencer;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;

public class ToDoItem {

    //fields
    private Integer id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;

    private Person creator;

    private Integer personId;
    private Date deadLineSQL;
    //constructors
    public ToDoItem() {
        this.id = TodoItemIdSequencer.nextId();
        this.done = true;
    }

    public ToDoItem(String title, String taskDescription, LocalDate deadline) {
        this();
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadline(deadline);

    }
    public ToDoItem(Integer id,String title, String taskDescription, LocalDate deadline) {
        setId(id);
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadline(deadline);
    }
    public ToDoItem(Integer id,String title, String taskDescription, LocalDate deadline, Person creator) {
        setId(id);
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadline(deadline);
        setCreator(creator);
    }
    public ToDoItem(Integer id,String title, String taskDescription, Date deadLineSQL, Integer personId) {
        setId(id);
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLineSQL(deadLineSQL);
        setPersonId(personId);
    }
    //methods


    public boolean isOverdue() {

        LocalDate nowTime = LocalDate.now();
        Period timeLeft = Period.between(nowTime, deadline);
        if (nowTime.compareTo(deadline) < 0) {
            System.out.println(timeLeft);
            return true;
        } else {
            System.out.print(" Times up deadline was: " + deadline + " Task completed:" + taskDescription + " ");
        }
        return false;
    }//isOverdue

    //getters & setters
    public Integer getId() {
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
        if (obj == null || getClass() != obj.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) obj;
        return id == toDoItem.id && Objects.equals(taskDescription, toDoItem.taskDescription) && Objects.equals(title, toDoItem.title)&& Objects.equals(personId,toDoItem.personId);
    }

    @Override
    public String toString() {
        return "Task id : " + id + " Title name : " + title + " Description : " + taskDescription + " deadline : " + deadLineSQL + " person id: " + personId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPersonId() {
        return personId;
    }

    public Date getDeadLineSQL() {
        return deadLineSQL;
    }

    public void setDeadLineSQL(Date deadLineSQL) {
        this.deadLineSQL = deadLineSQL;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;


    }
}//class
