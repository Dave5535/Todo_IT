package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ToDoItemTaskTest {
    private ToDoItemTask toDoItemTask;
    private Person person;
    private ToDoItem toDoItem;

    public ToDoItemTaskTest() {
    }

    @BeforeEach
    public void setUp() {

        this.person = new Person("test","test1","test@email");
        this.toDoItem = new ToDoItem("task","taskItem", LocalDate.parse("2003-06-01"));
        this.toDoItemTask = new ToDoItemTask(toDoItem,person);
    }

    @Test
    public void test_If_person_is_assigned(){
      assertEquals("test",toDoItemTask.getAssignee().getFirstName());
    }
}
