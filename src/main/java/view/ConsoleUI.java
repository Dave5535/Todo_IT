package view;

import Model.AppRole;
import Model.AppUser;
import Model.Person;
import Model.ToDoItem;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class ConsoleUI {

    public MainMenuAction displayMenu() {
        System.out.println("\t\t\t\t\t\t____Person____");
        System.out.print("1.FindAll Sql person\t");
        System.out.print("2.Create Sql person\t\t\t");
        System.out.println("3.Find Sql Name");
        System.out.print("4.Update Sql \t\t\t");
        System.out.print("5.Delete Sql \t\t\t\t");
        System.out.println("6.Find Sql ID");

        System.out.println("\t\t\t\t\t\t ____Task____");
        System.out.print("7.Create Sql item\t\t\t\t\t");
        System.out.print("8.FindAll Sql item\t\t\t\t\t\t");
        System.out.println("9.FindById Sql item");
        System.out.print("10.FindByDoneStatus Sql item\t\t");
        System.out.print("11.FindByAssignee (id) Sql item\t\t\t");
        System.out.println("12.FindByAssignee (person) item");
        System.out.print("13.FindByUnassigned Sql item\t\t");
        System.out.print("14.Update Sql item\t\t\t\t\t\t");
        System.out.println("15.Delete Sql item\t\t");

        System.out.println("0.Exit");

        System.out.println("Enter a number: ");
        int operationCode = getNumber();

        switch (operationCode) {
            case 1:
                return MainMenuAction.FINDALL_SQL_PERSON;
            case 2:
                return MainMenuAction.CREATE_SQL_PERSON;
            case 3:
                return MainMenuAction.FINDBYNAME_SQL;
            case 4:
                return MainMenuAction.UPDATE_SQL;
            case 5:
                return MainMenuAction.DELETE_SQL;
            case 6:
                return MainMenuAction.FINDBYID_SQL;


            case 7:
                return MainMenuAction.CREATE_SQL_TODO;
            case 8:
                return MainMenuAction.FINDALL_SQL_TODO;
            case 9:
                return MainMenuAction.FINDBYID_SQL_TODO;
            case 10:
                return MainMenuAction.FINDBYDONESTATUS_SQL_TODO;
            case 11:
                return MainMenuAction.FINDBYASSIGNEE_INT_TODO;
            case 12:
                return MainMenuAction.FINDBYASSIGNEE_PERSON_TODO;
            case 13:
                return MainMenuAction.FINDBYUNASSIGNED_SQL_TODO;
            case 14:
                return MainMenuAction.UPDATE_SQL_TODO;
            case 15:
                return MainMenuAction.DELETEBYID_SQL_TODO;
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
        AppUser appUserData = new AppUser(uN, Pwd, AppRole.ROLE_APP_USER);

        System.out.println("Enter firstName");
        String fN = scan.next();
        System.out.println("Enter lastName");
        String lN = scan.next();
        System.out.println("Enter email");
        String email = scan.next();
        return new Person(fN, lN, email, appUserData);
    }

    public ToDoItem getTodoItemData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a title");
        String t = sc.next();
        System.out.println("Enter a description of the task");
        String dOT = sc.next();
        System.out.println("Enter a deadline (yyyy-MM-DD");
        String deadline = sc.next();
        ToDoItem toDoItemData = new ToDoItem(t, dOT, LocalDate.parse(deadline));

        System.out.println("Enter a assignees Id .. if no assignee Enter 0");
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
