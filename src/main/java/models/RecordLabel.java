package models;

public class RecordLabel {
    private int id;
    private String name;
    private String location;
    private String manager;


    public RecordLabel(String name, String location,String manager ) {
        this.name = name;
        this.location = location;
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(int id) {
    }
}
