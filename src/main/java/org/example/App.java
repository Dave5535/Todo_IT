package org.example;


import InterFace.*;
import Model.AppUser;
import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
        AppUserDAO appUserDAO = new AppUserDAOCollection();
        PersonDAO personDAO = new PersonDAOCollection();
        TodoItemDAO todoItemDAO = new TodoItemDAOCollection();
        TodoitemTaskDAO todoitemTaskDAO = new TodoItemTaskDAOCollection();

        AppUser user = new AppUser("Dave5535", "123456789");
        AppUser test = new AppUser("test", "Admin6789");

        appUserDAO.persist(user);
        appUserDAO.persist(test);

        Person person1 = new Person("person1", "person1", "person.per@person1");
        Person person2 = new Person("person2", "person2", "person.per@person2");
        Person registerPerson1 = personDAO.persist(person1);
        Person registerPerson2 = personDAO.persist(person2);

        //System.out.println(personDAO.findAll());
        // System.out.println(personDAO.findAll());
        //  System.out.println(personDAO.findByEmail("person.per@person1"));
        ToDoItem item1 = new ToDoItem("test1", "test1", LocalDate.parse("2022-11-15"));
        ToDoItem item2 = new ToDoItem("test2", "test2", LocalDate.parse("2022-12-18"));

        ToDoItem itemData1 = todoItemDAO.persist(item1);
        ToDoItem itemData2 = todoItemDAO.persist(item2);

        ToDoItemTask itemYouCanDO1 = new ToDoItemTask(itemData1, registerPerson1);
        ToDoItemTask itemYouCanDO2 = new ToDoItemTask(itemData2, registerPerson2);

        todoitemTaskDAO.persist(itemYouCanDO1);
        todoitemTaskDAO.persist(itemYouCanDO2);


        System.out.println(todoitemTaskDAO.findById(1));

        System.out.println("________________");

        // todoItemDAO.findByDeadlineBefore(item1); work
        // System.out.println(personDAO.findAll());
//System.out.println(todoItemDAO.findById(1));
//System.out.println(todoItemDAO.findAllByDoneStatus(true));
//System.out.println(todoItemDAO.findByTitleContains("test1"));
//  System.out.println(todoItemDAO.findByDeadlineBefore(LocalDate.parse("2023-11-14")));
        //   System.out.println(todoItemDAO.findByDeadLineAfter(LocalDate.parse("2022-11-14")));


    }//main

}//class
