package view;

import Model.AppRole;
import Model.AppUser;
import Model.Person;
import Model.ToDoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static Model.AppRole.ROLE_APP_USER;

public class ConsoleUI {

    public MainMenuAction displayMenu() {
        System.out.println("1.Register");
        System.out.println("2.Create Task");
        System.out.println("3.Display All Tasks");
        System.out.println("4.Exit");

        System.out.println("Enter a number: ");
        int operationCode = getNumber();

        switch (operationCode) {
            case 1:
                return MainMenuAction.REGISTER;
            case 2:
                return MainMenuAction.CREATE_TASK;
            case 3:
                return MainMenuAction.DISPLAY_TASKS;
            default:
                return MainMenuAction.EXIT;
        }

    }
    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Person getPersonData() {
       Scanner scan = new Scanner(System.in);
        System.out.println("Enter UserName");
        String uN = scan.next();
        System.out.println("Enter Password (least 9 characters)");
        String Pwd = scan.next();
        AppUser appUserData = new AppUser(uN,Pwd,AppRole.ROLE_APP_USER);

        System.out.println("Enter firstName");
       String fN = scan.next();
        System.out.println("Enter lastName");
        String lN = scan.next();
        System.out.println("Enter email");
        String email = scan.next();
        return new Person(fN,lN,email,appUserData);
    }
    public ToDoItem getTodoItemData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a title");
        String t = sc.next();
        System.out.println("Enter a description of the task");
        String dOT = sc.next();
        System.out.println("Enter a deadline (yyyy-MM-DD");
        String deadline = sc.next();
        ToDoItem toDoItemData = new ToDoItem(t,dOT,LocalDate.parse(deadline));

        System.out.println("PersonId:");
        Integer personId = getNumber();
        Person personData = new Person();
        personData.setId(personId);

        toDoItemData.setCreator(personData);
        return toDoItemData;
    }

    public void displayPersonInformation(Person person) {
        System.out.println(person.toString());

    }
    public void displayTodoItemInformation(ToDoItem todoItem) {
        System.out.println(todoItem.toString());

    }
    public void displayTodoItemInformation(Collection<ToDoItem> todoItemList) {
        for (ToDoItem toDoItems : todoItemList)
        System.out.println(toDoItems.toString());
    }
}
