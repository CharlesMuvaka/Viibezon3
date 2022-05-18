package models;

import java.util.Objects;

public class RecordLabel {
    private int id;
    private String name;
    private String location;
    private String manager;

    private String avatarUrl;


    public RecordLabel(String name, String location,String manager ) {
        this.name = name;
        this.location = location;
        this.manager = manager;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordLabel that = (RecordLabel) o;
        return id == that.id && name.equals(that.name) && location.equals(that.location) && manager.equals(that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, manager);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(int id) {
        this.id = id;
    }
}
