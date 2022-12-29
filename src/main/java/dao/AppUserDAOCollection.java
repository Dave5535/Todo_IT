package dao;

import Exeption.DBConnectionException;
import Model.AppUser;
import MySqlConnection.MySqlConnection;
import SequencersPack.PersonIdSequencer;

import java.sql.*;
import java.util.*;

public class AppUserDAOCollection implements AppUserDAO {
    private List<AppUser> users;

private static AppUserDAOCollection instance;
    public AppUserDAOCollection() {
        users = new ArrayList<>();

    }

    public static AppUserDAOCollection getInstance(){
        if (instance == null) instance = new AppUserDAOCollection();
        return instance;
    }
    @Override
    public AppUser persist(AppUser appUser) {
if (appUser == null) throw new IllegalArgumentException("appUser was null");
     appUser.setId(PersonIdSequencer.nextId());
        users.add(appUser);
        return appUser;
    }


    @Override
    public AppUser findById(int id) {
        String query = "select * from appuser where id = ?";
        try(Connection connection = MySqlConnection.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ) {
preparedStatement.setInt(1,id);
            try (ResultSet result = preparedStatement.getGeneratedKeys();) {
                if (result.next()) {
                    System.out.println("item Id: " + result.getInt(1));
                    AppUser appUser = new AppUser(result.getString("user_name"),result.getString("_password"));
                    return appUser;
                }
            }

        }catch (DBConnectionException | SQLException e){
            System.out.println(e.getMessage());
        }


        return null;
    }

    @Override
    public AppUser findByUsername(String userInput) {
        if (userInput == null) throw new IllegalArgumentException("ssn was null");
        for (AppUser person : users)
            if (person.getUserName().equalsIgnoreCase(userInput)) return person;
        return null;
    }
    @Override
    public Collection<AppUser> findAll() {
        for (AppUser appUser : users)
            System.out.println(appUser);
        return users;
    }
    @Override
    public void remove(String username) {
        users.removeIf(removeItem -> removeItem.getUserName().equals(username));
    }
}
