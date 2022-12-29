package se.Lexicon;


import Exeption.DBConnectionException;
import MySqlConnection.MySqlConnection;
import controller.Controller;
import dao.PersonDAOCollection;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
         controller.doMainMenu();


    }//main
}//class
