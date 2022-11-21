package InterFaceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Person;
import org.example.ToDoItem;
import org.example.ToDoItemTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

public class TodoItemTaskDAOCollectionTest {

    private ToDoItemTask testObject;
    private Person person;

    private ToDoItem toDoItem;

    @BeforeEach
    public void setUp() {
        toDoItem = new ToDoItem("item", "test", LocalDate.parse("2000-05-02"));
        person = new Person("person", "Person", "Person@person");
        testObject = new ToDoItemTask(toDoItem,person );

    }


    @Test
    public void test_If_Persist_add_To_Collection() {
assertEquals(1,testObject.getId());
assertTrue(testObject.isAssigned());
    }

}
