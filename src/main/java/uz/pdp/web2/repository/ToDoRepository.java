package uz.pdp.web2.repository;

import lombok.SneakyThrows;
import uz.pdp.web2.model.Todo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO todo_users(owner_id,task,description,due_date,file_id) VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, todo.owner_id);
            preparedStatement.setString(2, todo.task);
            preparedStatement.setString(3, todo.description);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(todo.due_date));
            preparedStatement.setInt(5, todo.file_id);
            preparedStatement.execute();
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
                todo.owner_id = rs.getInt("owner_id");
                todo.task = rs.getString("task");
                todo.file_id = rs.getInt("file_id");
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

    @SneakyThrows
    public Connection getConnection() {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
