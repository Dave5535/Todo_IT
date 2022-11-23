package se.Lexicon;

import Model.AppUser;
import Model.Person;
import Model.ToDoItem;
import Model.ToDoItemTask;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ToDoItemTaskTest {
    private ToDoItemTask toDoItemTask;
    private Person person;
    private AppUser appUser;
    private ToDoItem toDoItem;

    public ToDoItemTaskTest() {
    }

    @BeforeEach
    public void setUp() {
appUser = new AppUser("user","password1");
        this.person = new Person("test","test1","test@email",appUser);
        this.toDoItem = new ToDoItem("task","taskItem", LocalDate.parse("2003-06-01"));
        this.toDoItemTask = new ToDoItemTask(toDoItem,person);
    }

    @Test
    public void test_If_person_is_assigned(){
      assertEquals("test",toDoItemTask.getAssignee().getFirstName());
    }
}
