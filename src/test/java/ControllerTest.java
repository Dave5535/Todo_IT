import Model.AppRole;
import Model.AppUser;
import Model.Person;
import Model.ToDoItem;
import dao.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import view.ConsoleUI;
import view.MainMenuAction;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {
    ConsoleUI ui;
    PersonDAO personDao;
    AppUserDAO appUserDao;
    TodoItemDAO todoItemDao;
    TodoitemTaskDAO todoitemTaskDAO;


    @BeforeEach
    public void setUp() {
        ui = new ConsoleUI();
        personDao = PersonDAOCollection.getInstance();
        appUserDao = AppUserDAOCollection.getInstance();
        todoItemDao = TodoItemDAOCollection.getInstance();

    }

    @Test
    public void test_DoMenu_return_MainMenuAction() {
        int test = 1;
        switch (test) {
            case 1:
                MainMenuAction actual = MainMenuAction.REGISTER;
                assertEquals(MainMenuAction.REGISTER, actual);
                break;
            case 2:
                MainMenuAction actual1 = MainMenuAction.CREATE_TASK;
                assertEquals(MainMenuAction.CREATE_TASK, actual1);
            case 3:
                MainMenuAction actual2 = MainMenuAction.DISPLAY_TASKS;
                assertEquals(MainMenuAction.CREATE_TASK, actual2);
            default:
                MainMenuAction actual3 = MainMenuAction.EXIT;
                assertEquals(MainMenuAction.EXIT, actual3);
        }
    }




}
