package sample;

public class Data {

    private int noOfTreasures;
    private int mapsize;

    public void setMapsize(Object mapsize) {
        String mapsizeString = (String) mapsize;
        switch (mapsizeString) {
            case "10x10": mapsize=10;
            break;
            case "20x20": mapsize=20;
            break;
            case "30x30": mapsize=30;
            break;
            default: mapsize=10;
            break;
        }
    }

    public int getNoOfTreasures() {
        return noOfTreasures;
    }

    public int getMapsize() {
        return mapsize;
    }

    public void setTreasureCount(Object treasureCount) {
        String treasureCountString = (String) treasureCount;
        this.noOfTreasures = Integer.parseInt(treasureCountString);
    }
}
