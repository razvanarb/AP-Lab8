package Lab8.Compulsory;

/**
 * Album class with just it's getters and setters.
 */

public class Album {
    private int id;
    private String name;
    private int releaseYear;
    private int artistId;

    public Album() {
    }

    public Album(int id, String name, int releaseYear, int artistId) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.artistId = artistId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
