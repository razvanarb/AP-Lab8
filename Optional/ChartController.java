package Lab8.Compulsory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * ChartController class that gets an database instance and executes different statements regarding charts table.
 */
public class ChartController {

    private Database db = Database.getInstance();

    public ChartController() throws SQLException {
    }

    /**
     * Inserts a new album in the charts table.
     */
    public void insert(int albumId, int rank, int chartId) {
        Connection con = db.getCon();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO charts(id_album, rank, id_chart) VALUES( ?, ?, ?)");
            stmt.setInt(1, albumId);
            stmt.setInt(2, rank);
            stmt.setInt(3, chartId);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }

    /**
     * Executes a query in the charts table showing the rankings of a given chart.
     *
     * @param id_dat the id of the given chart
     */
    public void showRankings(int id_dat) {

        List<Artist> artists = new ArrayList<Artist>();
        Connection conn = db.getCon();
        try {
            PreparedStatement pstmt = conn.prepareStatement("Select art.id, art.name, art.country from Charts c JOIN albums alb ON c.id_album=alb.id JOIN artists art ON alb.artist_id = art.id WHERE c.id_chart=? ORDER BY c.rank ASC");
            pstmt.setInt(1, id_dat);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                artists.add(new Artist(rs.getInt("Id"), rs.getString("name"), rs.getString("country")));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
        for (Artist art : artists) {
            System.out.println(art.getName());
        }
    }
}
