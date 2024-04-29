import java.sql.*;

public class DatabaseManager {
    private static final String url = "jdbc:postgresql://localhost:5432/bookchange";
    private static final String username = "postgres";
    private static final String passwords = "Na260206";

    public static void registertoplatform(String name, String surname, String login, String password, String email) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, passwords)) {
            String insertQuery = "INSERT INTO \"users\" (name, surname, login, password, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setString(2, surname);
            insertStatement.setString(3, login);
            insertStatement.setString(4, password);
            insertStatement.setString(5, email);
            insertStatement.executeUpdate();
        }
    }
    public static boolean login(String login, String password) throws SQLException{
        try {
            Connection connection=DriverManager.getConnection(url,username,passwords);
            String sql = "SELECT * FROM users WHERE login=? AND password=?;";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
