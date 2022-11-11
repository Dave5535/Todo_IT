package org.example;


import Model.AppRole;
import Model.AppUser;

public class App {
    public static void main(String[] args) {

        Person david = new Person("David", "Svantesson", "email@test"); // create an object in Person Class
        ToDoItem takeARun = new ToDoItem(" Take a Run ", " Training"); // create an object in ToDoItem
        ToDoItemTask task = new ToDoItemTask(takeARun, david);  // create an object in ToDoItemTask of Person and ToDoItem

        AppUser user = new AppUser("Dave5535","123", AppRole.ROLE_APP_USER);
        AppUser test = new AppUser("Test", "Admin",AppRole.ROLE_APP_ADMIN);


        System.out.println(david.toString()); // return person info, don't print Role
        // System.out.println(takeARun.getCreator().toString());
       // System.out.println(task.getAssignee().toString());

        System.out.println(user.toString()); // return the username

        System.out.println("_______________");
        takeARun.setCreator(david);       // set a task to a person
        task.setAssignee(david);

        System.out.println("_______________");
        System.out.println(takeARun.isOverdue()); // false ( one day late )
        System.out.println("_______________");


    }//main
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}//class
