package se.Lexicon;


import controller.Controller;
import dao.*;
import Model.AppUser;
import Model.Person;
import Model.ToDoItem;
import Model.ToDoItemTask;

import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.doMainMenu();
    }//main

}//class
