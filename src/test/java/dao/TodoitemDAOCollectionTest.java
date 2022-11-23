package dao;

import static org.junit.jupiter.api.Assertions.*;

import Model.ToDoItem;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

public class TodoitemDAOCollectionTest {
    private ToDoItem testObject;

    @BeforeEach
    public void setUp() {
        testObject = new ToDoItem("item", "test", LocalDate.parse("2000-05-02"));
    }

    @Test
    public void testObject_Test_If_Added() {
        assertEquals(1, testObject.getId());
        assertFalse(testObject.done());
        assertEquals("test", testObject.getTitle());
        assertTrue(testObject.isOverdue());
    }

    @Test
    public void testObject_If_value_is_null() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ToDoItem test = new ToDoItem(null, null, null);
            }
        });
    }
}

