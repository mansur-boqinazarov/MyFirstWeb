package uz.pdp.web2.repository;

import uz.pdp.web2.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mansurbek Boqinazarov
 */
public class UserRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/web_register";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "08042007BM";


    public UserRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(User user) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(first_name, last_name,email,password,phone,dateOfBirth) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,user.firstName);
            preparedStatement.setString(2,user.lastName);
            preparedStatement.setString(3,user.email);
            preparedStatement.setString(4,user.password);
            preparedStatement.setString(5,user.phone);
            preparedStatement.setDate(6, Date.valueOf(user.birthDate));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<User> getAll() {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            List<User> users = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.id = rs.getInt("id");
                user.firstName = rs.getString("first_name");
                user.lastName = rs.getString("last_name");
                user.email = rs.getString("email");
                user.password = rs.getString("password");
                user.phone = rs.getString("phone");
                user.birthDate = rs.getDate("dateOfBirth").toLocalDate();
                users.add(user);
            }
            return users;
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
