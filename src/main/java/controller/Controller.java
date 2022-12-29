package controller;

import Model.AppUser;
import Model.Person;
import Model.ToDoItem;
import dao.*;
import view.ConsoleUI;
import view.MainMenuAction;

import java.util.*;


public class Controller {
    ConsoleUI ui;
    PersonDAO personDao;
    AppUserDAO appUserDao;
    TodoItemDAO todoItemDao;


    public Controller() {
        ui = new ConsoleUI();
        personDao = PersonDAOCollection.getInstance();
        appUserDao = AppUserDAOCollection.getInstance();
        todoItemDao = TodoItemDAOCollection.getInstance();
    }

    public static int scannerInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

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
                case CREATE_SQL_ITEM:
                    createToDoItemSQL();
                    break;
                case CREATE_SQL_PERSON:
                    createPersonSQL();
                    break;
                case FINDBYNAME_SQL:
                    findByNameSQL();
                    break;
                case UPDATE_SQL:
                    uppDateSQL();
                    break;
                case DELETE_SQL:
                    deleteSQL();
                    break;
                case FINDBYID_SQL:
                    findByID();
                    break;
                case CREATE_SQL_TODO:
                    createTask();
                    break;
                case FINDALL_SQL_TODO:
                    findAllSQLTodo();
                    break;
                case FINDBYID_SQL_TODO:
                    findTodoById();
                    break;
                case FINDBYDONESTATUS_SQL_TODO:
                    findByDoneStatus_SQL_Todo();
                    break;
                case FINDBYASSIGNEE_INT_TODO:
                    findByAssigneeTodoSQL();
                    break;
                case FINDBYASSIGNEE_PERSON_TODO:
                    findByAssigneeTodoPerson_SQL();
                    break;
                case FINDBYUNASSIGNED_SQL_TODO:  //Todo make something FINDBYUNASSIGNED 14
                    findByUnassigned_SQL_Todo();
                    break;
                case UPDATE_SQL_TODO:
                    updateTodo();
                    break;
                case DELETEBYID_SQL_TODO:
                    deleteSQL_Todo();
                    break;
                case FINDALL_SQL_PERSON:
                    findAllPerson();
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

    public void createToDoItemSQL() {
        ToDoItem toDoItem = ui.getTodoItemData();
        todoItemDao.create(toDoItem);
    }

    public void createPersonSQL() {
        Person person = ui.getPersonData();
        personDao.create(person);
    }

    public void findByNameSQL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name");
        String name = scanner.nextLine();
        personDao.findByName(name);
    }

    public void uppDateSQL() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a id number to update");
        int id = scannerInt();
        System.out.println("Enter FirstName");
        String firstName = sc.next();
        System.out.println("Enter LastName");
        String lastName = sc.next();
        System.out.println("Enter Email");
        String email = sc.next();

        Person person = new Person(id, firstName, lastName, email);
        personDao.update(person);
    }

    public void deleteSQL() {
        System.out.println("Enter an Id ... Warning you are gonna delete person! ");
        personDao.deleteById(scannerInt());
    }

    public void findByID() {
        System.out.println("Enter person id");
        System.out.println(personDao.findById(scannerInt()));

    }

    public void createTask() {
        ToDoItem toDoItem = ui.getTodoItemData();
        todoItemDao.create(toDoItem);
    }

    public void updateTodo() {
        ToDoItem toDoItem = ui.getTodoItemData();
        System.out.println("Enter 1 if you want to set the task as finished ");
        if (scannerInt() == 1){
            toDoItem.setDone(true);
        }

        System.out.println("Enter a task id you want to update");
        toDoItem.setId(scannerInt());

        todoItemDao.update(toDoItem);
    }

    public void findAllSQLTodo() {
        System.out.println(todoItemDao.findAll());

    }

    public void findAllPerson() {
        System.out.println(personDao.findAll());
    }

    public void findTodoById() {

        System.out.println("Enter a task id");
        System.out.println(todoItemDao.findById(scannerInt()));
    }

    public void deleteSQL_Todo() {
        System.out.println("Enter an task id ... Warning you are deleting a task");
        todoItemDao.deleteById(scannerInt());
    }

    public void findByAssigneeTodoSQL() {
        System.out.println("person id");
        todoItemDao.findByAssignee(scannerInt());
    }

    public void findByAssigneeTodoPerson_SQL() {
        System.out.println("Enter a persons id");
        Person person = personDao.findById(scannerInt());
        System.out.println(todoItemDao.findByAssignee(person));
    }

    public void findByDoneStatus_SQL_Todo() {

        System.out.println(todoItemDao.findByDoneStatus(true));
    }

    public void findByUnassigned_SQL_Todo() {
        System.out.println(todoItemDao.findByUnAssigneeTodoItems());
    }
}
