package Lab8.Compulsory;

/**
 * Chart class with just it's getters and setters.
 */
public class Chart {

    private int albumId;
    private int rank;
    private int chartId;

    public Chart() {
    }

    public Chart(int albumId, int rank, int chartId) {

        this.albumId = albumId;
        this.rank = rank;
        this.chartId = chartId;
    }


    public int getAlbumId() {
        return albumId;
    }

    public int getRank() {
        return rank;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }
}
