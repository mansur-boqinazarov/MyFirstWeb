package uz.pdp.web2.todo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mansurbek Boqinazarov
 */
public class ToDoRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/web_register";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "08042007BM";

    public ToDoRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(Todo todo) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO todo_users(task,description,created_at,due_date,completed) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, todo.task);
            preparedStatement.setString(2, todo.description);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(todo.created_at));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(todo.due_date));
            preparedStatement.setBoolean(5, todo.completed);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Todo> getAll(){
        Connection connection = getConnection();
        List<Todo> todos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo_users");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.id = rs.getInt("id");
                todo.task = rs.getString("task");
                todo.description = rs.getString("description");
                todo.created_at = rs.getTimestamp("created_at").toLocalDateTime();
                todo.due_date = rs.getTimestamp("due_date").toLocalDateTime();
                todo.completed = rs.getBoolean("completed");
                todos.add(todo);
            }
            return todos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
