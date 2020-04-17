package Lab8.Compulsory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ArtistController class that gets an database instance and executes different statements regarding artist table.
 */
public class ArtistController {

    private Database db = Database.getInstance();

    public ArtistController() throws SQLException {
    }

    /**
     * Executes a name query in the artist table.
     */
    public Artist findByName(String name) {
        Connection con = db.getCon();
        PreparedStatement stmt = null;
        Artist artist = new Artist();
        try {
            stmt = con.prepareStatement("SELECT * FROM artists WHERE name = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                artist.setName(rs.getString("name"));
                artist.setCountry(rs.getString("country"));
            }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
        return artist;
    }

    /**
     * Inserts a new artist in the artists table.
     */

    public void insert(String name, String country) {
        Connection con = db.getCon();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO artists(name, country) VALUES(?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, country);
            stmt.executeUpdate();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
