package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres","postgres","zl13801393#");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JdbcConnection() throws SQLException {
    }

    public static Connection getConnection() {
        return connection;
    }
}
