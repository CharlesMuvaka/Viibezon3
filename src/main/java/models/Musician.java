package models;

public class Musician {
    private int id;
    private String name;
    private String instrument;

    private String artistType;

    private  int recordLabelId;




    public Musician(String name, String instrument, String artistType,int recordLabelId) {
        this.name = name;
        this.instrument = instrument;
        this.artistType = artistType;
        this.recordLabelId = recordLabelId;
    }

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

    public int getRecordLabelId() {
        return recordLabelId;
    }

    public void setRecordLabelId(int recordLabelId) {
        this.recordLabelId = recordLabelId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void setBand(String band) {
        this.artistType = band;
    }

    public String toString() {
        return "Musician: " + this.name + " " + this.instrument + " " + this.artistType;
    }

}
