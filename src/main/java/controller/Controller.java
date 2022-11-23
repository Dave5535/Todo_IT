package controller;


import Model.AppUser;
import Model.Person;
import Model.ToDoItem;
import dao.*;
import view.ConsoleUI;
import view.MainMenuAction;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static view.MainMenuAction.REGISTER;

public class Controller {
    ConsoleUI ui;
    PersonDAO personDao;
    AppUserDAO appUserDao;
    TodoItemDAO todoItemDao;
    TodoitemTaskDAO todoitemTaskDAO;

    public Controller() {
        ui = new ConsoleUI();
        personDao = PersonDAOCollection.getInstance();
        appUserDao = AppUserDAOCollection.getInstance();
        todoItemDao = TodoItemDAOCollection.getInstance();
    }

    //Menu
    public void doMainMenu() {

        while (true) {
            MainMenuAction action = ui.displayMenu();
            switch (action) {
                case REGISTER:
                    doRegister();
                    break;
                case CREATE_TASK:
                    doCreateTodoItem();
                    break;
                case DISPLAY_TASKS:
                    doDisplayTodoItems();
                    break;
                case EXIT:
                    System.exit(0);
            }

        }
    }

    public void doRegister() {
        Person personData = ui.getPersonData();
        AppUser appUserData = personData.getAppUser();
        AppUser createdAppUser = appUserDao.persist(appUserData);

        personData.setAppUser(createdAppUser);
        Person createdPerson = personDao.persist(personData);

        ui.displayPersonInformation(createdPerson);

    }

    public void doCreateTodoItem() {
        ToDoItem toDoItemData = ui.getTodoItemData();
        Person registeredPerson = toDoItemData.getCreator();

        Person foundPerson = personDao.findById(registeredPerson.getId());

        toDoItemData.setCreator(foundPerson);
        ToDoItem createdTodoItem = todoItemDao.persist(toDoItemData);

        ui.displayTodoItemInformation(createdTodoItem);
    }

    public void doDisplayTodoItems() {
     Collection<ToDoItem> toDoItemList = todoItemDao.findAll();
     ui.displayTodoItemInformation(toDoItemList);
    }

}
