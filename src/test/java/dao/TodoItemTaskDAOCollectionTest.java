package dao;

import static org.junit.jupiter.api.Assertions.*;

import Model.AppUser;
import Model.Person;
import Model.ToDoItem;
import Model.ToDoItemTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTaskDAOCollectionTest {

    private ToDoItemTask testObject;
    private Person person;
private AppUser appUser;
    private ToDoItem toDoItem;

    @BeforeEach
    public void setUp() {
        toDoItem = new ToDoItem("item", "test", LocalDate.parse("2000-05-02"));
     appUser =new AppUser("user","Password1");
        person = new Person("person", "Person", "Person@person",appUser);
        testObject = new ToDoItemTask(toDoItem,person );

    }


    @Test
    public void test_If_Persist_add_To_Collection() {
assertEquals(1,testObject.getId());
assertTrue(testObject.isAssigned());
    }

}
