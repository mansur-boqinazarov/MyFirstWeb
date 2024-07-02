package uz.pdp.web2.repository;

import lombok.SneakyThrows;
import uz.pdp.web2.model.File;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mansurbek Boqinazarov
 */
public class FileRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/web_register";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "08042007BM";


    @SneakyThrows
    public File get(int id){
        Connection connection = getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM file WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                File file = new File();
                file.setId(resultSet.getInt("id"));
                file.setOriginal_name(resultSet.getString("original_name"));
                file.setMime_type(resultSet.getString("mime_type"));
                file.setNew_name(resultSet.getString("new_name"));
                file.setFile(resultSet.getBytes("file_data"));
                file.setUploadTime(resultSet.getTimestamp("upload_time").toLocalDateTime());
                return file;
            }

        return null;
    }

    public int save(File file){
        Connection connection = getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO file(original_name,mime_type,new_name,file_data) VALUES (?,?,?,?) returning id ");
            ps.setString(1, file.getOriginal_name());
            ps.setString(2, file.getMime_type());
            ps.setString(3, file.getNew_name());
            ps.setBytes(4, file.getFile());
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next())
                return resultSet.getInt("id");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public List<File> getAll() {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM file");
            List<File> files = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                File file = new File();
                file.setId(rs.getInt("id"));
                file.setOriginal_name(rs.getString("original_name"));
                file.setMime_type(rs.getString("mime_type"));
                file.setNew_name(rs.getString("new_name"));
                file.setFile(rs.getBytes("file_data"));
                file.setUploadTime(rs.getTimestamp("upload_time").toLocalDateTime());
                files.add(file);
            }
            return files;
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
