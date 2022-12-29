package dao;

import Exeption.DBConnectionException;
import Model.Person;
import Model.ToDoItem;
import MySqlConnection.MySqlConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements TodoItemDAO {
    private List<ToDoItem> items;
    public static TodoItemDAOCollection instance;

    public TodoItemDAOCollection() {
        items = new ArrayList<>();
    }

    public static TodoItemDAOCollection getInstance() {
        if (instance == null) instance = new TodoItemDAOCollection();
        return instance;
    }

    @Override
    public ToDoItem persist(ToDoItem todoItem) {
        items.add(todoItem);
        return todoItem;
    }


    @Override
    public ToDoItem findById(int id) {
        String query = "select * from task where id = ?";
        Integer taskId = null;
        String title = null;
        String _description = null;
        Date date = null;
        Integer personId = null;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    taskId = resultSet.getInt("id");
                    title = resultSet.getString("title");
                    _description = resultSet.getString("_description");
                    date = resultSet.getDate("deadline");
                    personId = resultSet.getInt("person_id");
                }
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return new ToDoItem(taskId, title, _description, date, personId);
    }


    @Override
    public Collection<ToDoItem> findAllByDoneStatus(Boolean done) {
        if (done == null) throw new IllegalArgumentException("done was null");
        List<ToDoItem> findStatus = new ArrayList<>();
        for (ToDoItem task : items) {
            if (task.done() && task.done() == done)
                findStatus.add(task);
        }
        return findStatus;
    }

    @Override
    public Collection<ToDoItem> findByTitleContains(String title) {
        if (title == null) throw new IllegalArgumentException("title was null");
        List<ToDoItem> containTitle = new ArrayList<>();
        for (ToDoItem toDoItem : items)
            if (toDoItem.getTitle().equalsIgnoreCase(title))
                containTitle.add(toDoItem);
        return containTitle;
    }

    @Override
    public Collection<ToDoItem> findByPersonId(int personId) {
        List<ToDoItem> personList = new ArrayList<>();
        for (ToDoItem person : items)
            if (person.getId() == personId)
                personList.add(person);
        return personList;
    }

    @Override
    public Collection<ToDoItem> findByDeadlineBefore(LocalDate date) {
        List<ToDoItem> deadLineBefore = new ArrayList<>();
        for (ToDoItem timeLeft : items) {
            LocalDate findDate = timeLeft.getDeadline();
            if (findDate.isBefore(date) || findDate.equals(date))
                deadLineBefore.add(timeLeft);
        }
        return deadLineBefore;
    }

    @Override
    public Collection<ToDoItem> findByDeadLineAfter(LocalDate date) {
        List<ToDoItem> deadLineAfter = new ArrayList<>();
        for (ToDoItem time : items) {
            LocalDate findDate = time.getDeadline();
            if (findDate.isAfter(date) || findDate.equals(date))
                deadLineAfter.add(time);
        }
        return deadLineAfter;
    }

    @Override
    public void remove(int id) {
        items.removeIf(removeItem -> removeItem.getId() == id);
    }

    @Override
    public Collection<ToDoItem> findByDoneStatus(boolean item) {
        String query = "Select * from task where done = ? ";
        Integer id = null;
        String title = null;
        String _description = null;
        Date date = null;
        Integer personId = null;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setBoolean(1, item);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    title = resultSet.getString("title");
                    _description = resultSet.getString("_description");
                    date = resultSet.getDate("deadline");
                    personId = resultSet.getInt("person_id");
                    ToDoItem toDoItem = new ToDoItem(id, title, _description, date, personId);
                    items.add(toDoItem);
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return items;
    }

    @Override
    public void create(ToDoItem toDoItem) {
        String query = "insert into task(title,_description,person_id,deadline) values (?,?,?,?)";
        Integer creatorId = toDoItem.getCreator().getId();
        Date date = Date.valueOf(toDoItem.getDeadline());
        try (
                Connection connection = MySqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, toDoItem.getTitle());
            preparedStatement.setString(2, toDoItem.getTaskDescription());

            preparedStatement.setDate(4, date);
            if (creatorId != 0) {
                preparedStatement.setInt(3, toDoItem.getCreator().getId());
            } else {
                preparedStatement.setNull(3, 0);
            }


            preparedStatement.executeUpdate();
            try (ResultSet result = preparedStatement.getGeneratedKeys();) {
                if (result.next()) {
                    System.out.println("item Id: " + result.getInt(1));
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void findByAssignee(int assignee) {
        String query = "select * from task where person_id = ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, assignee);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Title: " + resultSet.getString("title"));
                    System.out.println("Description: " + resultSet.getString("_description"));
                    System.out.println("Deadline" + resultSet.getDate("deadline"));
                    System.out.println("Person id" + resultSet.getInt("person_id"));
                    System.out.println("_________");
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(ToDoItem toDoItem) {
        String query = "update task set title = ?, _description = ?, deadline = ?, done = ?, person_id = ? where id = ?  ";
        Integer taskId = toDoItem.getId();
        Integer personId = toDoItem.getCreator().getId();
        Date date = Date.valueOf(toDoItem.getDeadline());
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, toDoItem.getTitle());
            preparedStatement.setString(2, toDoItem.getTaskDescription());
            preparedStatement.setDate(3, date);
            preparedStatement.setBoolean(5, toDoItem.done());
            preparedStatement.setInt(6, taskId);

            if (personId != 0) {
                preparedStatement.setInt(4, toDoItem.getCreator().getId());
            } else {
                preparedStatement.setNull(4, 0);
            }
            int result = preparedStatement.executeUpdate();
            System.out.println(result);

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteById(int id) {
        String query = "delete from task where id = ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Collection<ToDoItem> findByAssignee(Person person) {
        String query = "select * from task where person_id = ?";
        int personIdNumber = person.getId();
        Integer id = null;
        String title = null;
        String _description = null;
        Date date = null;
        Integer personId = null;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, personIdNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    title = resultSet.getString("title");
                    _description = resultSet.getString("_description");
                    date = resultSet.getDate("deadline");
                    personId = resultSet.getInt("person_id");
                    ToDoItem toDoItem = new ToDoItem(id, title, _description, date, personId);
                    items.add(toDoItem);
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }


        return items;
    }

    @Override
    public Collection<ToDoItem> findByUnAssigneeTodoItems() {
        String query = "select * from task ";
        Integer id = null;
        String title = null;
        String _description = null;
        Date date = null;
        Integer personId = null;
        Integer done = null;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    title = resultSet.getString("title");
                    _description = resultSet.getString("_description");
                    date = resultSet.getDate("deadline");
                    personId = resultSet.getInt("person_id");
                    done = resultSet.getInt("done");

                    ToDoItem toDoItem = new ToDoItem(id, title, _description, date, personId);
                    if (done == 0){
                        items.add(toDoItem);
                    }

                }
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }


    @Override
    public Collection<ToDoItem> findAll() {
        String query = "select * from task";
        Integer id = null;
        String title = null;
        String _description = null;
        Date date = null;
        Integer personId = null;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    title = resultSet.getString("title");
                    _description = resultSet.getString("_description");
                    date = resultSet.getDate("deadline");
                    personId = resultSet.getInt("person_id");
                    ToDoItem toDoItem = new ToDoItem(id, title, _description, date, personId);
                    items.add(toDoItem);
                }
            }
        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }
}
