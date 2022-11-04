package org.example;


public class App {
    public static void main(String[] args) {

        Person david = new Person("David", "Svantesson","email@test"); // create an object in Person Class
        Person test = new Person("test", "testsson", "test@");

        ToDoItem takeARun = new ToDoItem(" Take a Run ", " Training "); // create an object in ToDoItem / setting the Person to a task?
        ToDoItem shopping = new ToDoItem(" Go buy milk ", " Shop List ");

        ToDoItemTask task = new ToDoItemTask(takeARun,david);  // create an object in ToDoItemTask of Person and ToDoItem

takeARun.setCreator(david);
task.setAssignee(david);
       System.out.println(david.getSummary());
        System.out.println("_______________");

        System.out.println(takeARun.getCreator().getSummary()); // return Null
        System.out.println("_______________");

        System.out.println( task.getAssignee().getSummary()); // return Exception


        System.out.println("_______________");
       // System.out.println(takeARun.isOverdue()); // false ( one day late )

    }//main
}//class
