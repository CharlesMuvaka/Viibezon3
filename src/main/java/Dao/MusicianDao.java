package Dao;

import models.Musician;
import models.Song;

import java.util.List;

public interface MusicianDao {
    //CRUD
    void add(Musician musician);

    List<Musician> getAll();

    Musician findById(int id);

    void update(int id, Musician musician);

    void deleteById(int id);

    List<Song> getAllSongs(int id);

}
