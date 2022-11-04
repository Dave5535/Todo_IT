package org.example;


public class App {
    public static void main(String[] args) {

        Person david = new Person("David", "Svantesson", "email@test"); // create an object in Person Class
        ToDoItem takeARun = new ToDoItem(" Take a Run ", " Training "); // create an object in ToDoItem
        ToDoItemTask task = new ToDoItemTask(takeARun, david);  // create an object in ToDoItemTask of Person and ToDoItem

        System.out.println(david.getSummary()); // return name
        System.out.println("_______________");
        takeARun.setCreator(david);
        System.out.println(takeARun.getCreator().getSummary()); // return Null  ---- why?
        System.out.println("_______________");

        task.setAssignee(david);
        System.out.println(task.getAssignee().getSummary()); // if it has no owner -> Exception NullPointer ---- why ?


        System.out.println("_______________");
        System.out.println(takeARun.isOverdue()); // false ( one day late )

    }//main
}//class
