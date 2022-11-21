package InterFaceTest;

import InterFace.*;
import Model.AppUser;
import org.example.Person;
import org.example.ToDoItem;
import org.example.ToDoItemTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class TodoItemTaskDAOCollectionTest {
    private Person person1;
    private ToDoItem item1;
    private ToDoItemTask itemAndPerson;

@BeforeEach
        public void setUp(){
    AppUserDAO appUserDAO = new AppUserDAOCollection();
    PersonDAO personDAO = new PersonDAOCollection();
    TodoItemDAO todoItemDAO = new TodoItemDAOCollection();
    TodoitemTaskDAO todoitemTaskDAO = new TodoItemTaskDAOCollection();
    AppUser appUserTest1 = new AppUser("appUserTest1", "appUserTest1");
    AppUser appUserTest2 = new AppUser("appUserTest2", "appUserTest2");
    person1 = new Person("person1", "person1", "person.per@person1");
    Person registerPerson1 = personDAO.persist(person1);
    item1 = new ToDoItem("test1", "test1", LocalDate.parse("2022-11-15"));
    ToDoItem itemData1 = todoItemDAO.persist(item1);
    itemAndPerson = new ToDoItemTask(itemData1, registerPerson1);
    todoitemTaskDAO.persist(itemAndPerson);


        }


    @Test
    public void test_If_Persist_add_To_Collection(){


    }

}
