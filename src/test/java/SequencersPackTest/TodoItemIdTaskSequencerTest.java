package SequencersPackTest;

import InterFace.*;
import org.example.Person;
import org.example.ToDoItem;
import org.example.ToDoItemTask;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TodoItemIdTaskSequencerTest {
    @Test
    public void test_If_Next_Id_Is_Plus_one(){
        AppUserDAO appUserDAO = new AppUserDAOCollection();
        PersonDAO personDAO = new PersonDAOCollection();
        TodoItemDAO todoItemDAO = new TodoItemDAOCollection();
        TodoitemTaskDAO todoitemTaskDAO = new TodoItemTaskDAOCollection();
        Person person1 = new Person("person1", "person1", "person.per@person1");
        Person person2 = new Person("person2", "person2", "person.per@person2");
        Person registerPerson1 = personDAO.persist(person1);
        Person registerPerson2 = personDAO.persist(person2);

        ToDoItem item1 = new ToDoItem("test1", "test1", LocalDate.parse("2022-11-15"));
        ToDoItem item2 = new ToDoItem("test2", "test2", LocalDate.parse("2022-12-18"));
        ToDoItem itemData1 = todoItemDAO.persist(item1);
        ToDoItem itemData2 = todoItemDAO.persist(item2);

        ToDoItemTask test1 = new ToDoItemTask(itemData1, registerPerson1);
        ToDoItemTask test2 = new ToDoItemTask(itemData2, registerPerson2);

        String actual1 = String.valueOf(test1.getId());
        String expected1 = "1";
        String actual2 = String.valueOf(test2.getId());
        String expected2 = "2";
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

}
