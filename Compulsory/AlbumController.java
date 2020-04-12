package Lab8.Compulsory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AlbumController class that gets an database instance and executes different statements regarding albums table.
 */
public class AlbumController {

    private Database db = Database.getInstance();

    public AlbumController() throws SQLException {
    }

    /**
     * Executes a artistId query in the albums table.
     */
    public Album findByArtist(int artistId) {
        Connection con = db.getCon();
        PreparedStatement stmt = null;
        Album album = new Album();
        try {
            stmt = con.prepareStatement("SELECT * FROM albums WHERE artist_id = ?");
            stmt.setInt(1, artistId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                album.setName(rs.getString("name"));
                album.setArtistId(rs.getInt("artist_id"));
                album.setReleaseYear(rs.getInt("release_year"));
            }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
        return album;
    }

    /**
     * Inserts a new album in the albums table.
     */

    public boolean insert(String name, int artistId, int releaseYear) {
        Connection conn = db.getCon();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO albums(name, artist_id, release_year) VALUES(?, ?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, artistId);
            stmt.setInt(3, releaseYear);
            stmt.executeUpdate();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
        return true;
    }
}
