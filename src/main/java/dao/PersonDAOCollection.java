package dao;

import Exeption.DBConnectionException;
import Model.AppUser;
import Model.Person;
import MySqlConnection.MySqlConnection;
import SequencersPack.PersonIdSequencer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class PersonDAOCollection implements PersonDAO {
    private List<Person> persons;
    public static PersonDAOCollection instance;

    public PersonDAOCollection() {
        persons = new ArrayList<>();
    }

    public static PersonDAOCollection getInstance() {
        if (instance == null) instance = new PersonDAOCollection();
        return instance;

    }

    @Override
    public Person persist(Person person) {
        if (person == null) throw new IllegalArgumentException("person was null");
        if (findAll() == person) throw new IllegalArgumentException("person do already exist in memory");
        person.setId(PersonIdSequencer.nextId());
        persons.add(person);
        return person;
    }

    @Override
    public Person findByEmail(String email) {
        if (email == null) throw new IllegalArgumentException("ssn was null");
        for (Person person : persons)
            if (person.getEmail().equalsIgnoreCase(email)) return person;
        return null;
    }

    @Override
    public Person findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        for (Person person : persons)
            if (Objects.equals(person.getId(), person.getId())) return person;
        return null;
    }

    @Override
    public Collection<Person> findAll() {
String query = "select * from person";
int id = 0;
String firstName = null;
String lastName = null;
String email = null;
Date date = null;
Integer appId = null;
try(Connection connection = MySqlConnection.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement(query);
){
    try (ResultSet resultSet = preparedStatement.executeQuery();) {

        while (resultSet.next()) {
            id = resultSet.getInt("id");
           firstName = resultSet.getString("first_name");
            lastName = resultSet.getString("last_name");
           email = resultSet.getString("email");
            date =resultSet.getDate("reg_date");
            appId = resultSet.getInt("appuser_id");
            Person person = new Person(id,firstName,lastName,email,date,appId);
            persons.add(person);
        }
    }
}catch (DBConnectionException | SQLException e) {
    System.out.println(e.getMessage());
}
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(int id) {
        persons.removeIf(removeItem -> removeItem.getId() == id);
    }

    @Override
    public void create(Person person) { // Person(fN,lN,email,appUserData)

        String queryAppUser = "insert into appuser(USER_NAME,_PASSWORD) values (?,?)";
        String queryPerson = "insert into person(first_name,last_name,email,appuser_id) values (?,?,?,?)";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatementAppUser = connection.
                     prepareStatement(queryAppUser, Statement.RETURN_GENERATED_KEYS);) {
            connection.setAutoCommit(false);

            preparedStatementAppUser.setString(1, person.getAppUser().getUserName());
            preparedStatementAppUser.setString(2, person.getAppUser().getPassword());

            preparedStatementAppUser.executeUpdate();
            Integer userid = null;

            try (ResultSet resultSet = preparedStatementAppUser.getGeneratedKeys()) {
                if (resultSet.next()) {
                    userid = resultSet.getInt(1);
                }
            }
            if (userid == null) {
                throw new RuntimeException("getGeneratedKeys value is null!");
            }


            try (
                    PreparedStatement preparedStatementPerson = connection.prepareStatement(queryPerson,
                            Statement.RETURN_GENERATED_KEYS);
            ) {

                preparedStatementPerson.setString(1, person.getFirstName());
                preparedStatementPerson.setString(2, person.getLastName());
                preparedStatementPerson.setString(3, person.getEmail());
                preparedStatementPerson.setInt(4, userid);

                preparedStatementPerson.executeUpdate();

                try (ResultSet result = preparedStatementPerson.getGeneratedKeys();) {
                    if (result.next()) {
                        System.out.println("Person Id: " + result.getInt(1));
                    }
                }
            }
            connection.commit();
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void findByName(String name) {
        String query = "select * from person where first_name = ? ";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    System.out.println("Person Id: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("first_name") + " " + ("last_name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("registered date: " + resultSet.getDate("reg_date"));
                    System.out.println("UserId: " + resultSet.getInt("appuser_id"));
                    System.out.println("-------------");
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Person person) {
        String query = "update person set first_name = ?, last_name = ?, email = ? where id = ?";
        int personId = person.getId();
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, personId);

            int result = preparedStatement.executeUpdate();
            System.out.println(result);

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from person where id = ?";
        try(Connection connection = MySqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1,id);
           preparedStatement.executeUpdate();
            int result = preparedStatement.executeUpdate();
            System.out.println(result);

        }catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Person findById(int id) {
        String query = "Select * from person where id = ?";
        int personId = 0;
        String firstName = null;
        String lastName = null;
        String email = null;
        Date date = null;
        Integer appId = null;
        Person person = null;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    firstName = resultSet.getString("first_name");
                    lastName = resultSet.getString("last_name");
                    email = resultSet.getString("email");
                    date =resultSet.getDate("reg_date");
                    appId = resultSet.getInt("appuser_id");
                    person = new Person(id,firstName,lastName,email,date,appId);

                }
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return person;
    }

}
