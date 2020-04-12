package Lab8.Compulsory;


import java.sql.SQLException;

/**
 * Main class in which I implemented a short test in which I introduce 2 artists and 1 album and I search for 1 album and 1 artist.
 */

public class Main {

    public static void main(String[] args) throws SQLException {

        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();
        artistController.insert("Marilyn Manson", "USA");
        artistController.insert("DJ Snake", "France");
        albumController.insert("Carte Blanche", 2, 2019);

        Artist arCautat = artistController.findByName("DJ Snake");
        System.out.println(arCautat.getName());

        Album alCautat = albumController.findByArtist(2);
        System.out.println(alCautat.getName());

    }
}

