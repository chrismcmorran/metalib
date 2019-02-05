package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    public SQL() {

    }

    /**
     * Attempts to open a Connection to the given database.
     * @param db The database as a string.
     * @return A Connection.
     */
    public Connection SQLite(String db) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // create a database connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + db);

            if (!connection.isClosed()) {
                return connection;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
