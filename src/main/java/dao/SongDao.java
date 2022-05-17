package dao;

import models.Song;

import java.util.List;

public interface SongDao {
    //CRUD
    void add(Song song);

    List<Song> getAll();

    Song findById(int id);

    void update(int id, Song song);

    void deleteById(int id);
}
