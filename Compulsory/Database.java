package Lab8.Compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

    private String username = "dba";
    private String password = "sql";
    private Connection con;
    private static Database instance;

    /**
     * Function that makes the connection
     *
     * @throws SQLException
     */
    public Database() throws SQLException {
        con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Razvand\\Desktop\\data de baze\\MusicAlbums.db", username, password);
        if (con != null) {
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Failed to connect to database!");
        }
    }

    public Connection getCon() {
        return con;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


}
