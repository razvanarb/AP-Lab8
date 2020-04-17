package Lab8.Compulsory;


import java.sql.SQLException;

/**
 * Main class in which I implemented a short test in which I introduce 5 artists and 5 albums and I show the rankings of the 1st chart
 */

public class Main {

    public static void main(String[] args) throws SQLException {

        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();
        ChartController chartController = new ChartController();

        artistController.insert("Marilyn Manson", "USA");
        artistController.insert("DJ Snake", "France");
        artistController.insert("Eminem", "USA");
        artistController.insert("Slipknot", "USA");
        artistController.insert("Michael Jackson", "USA");

        albumController.insert("Carte Blanche", 2, 2019);
        albumController.insert("The Eminem Show",3,2002);
        albumController.insert("Revival",3,2017);
        albumController.insert("All Hope is Gone", 4,  2005);
        albumController.insert("Thriller", 5,  1982);

        chartController.insert(2,1,1);
        chartController.insert(4,3,1);
        chartController.insert(1,2,1);
        chartController.insert(5,1,2);
        chartController.insert(3,2,2);

        chartController.showRankings(1);
    }
}

