package Dao;

import models.Musician;

import java.util.List;

public interface MusicianDao {
    //CRUD
    void add(Musician musician);

    List<Musician> getAll();

    Musician findById(int id);

    void update(int id, Musician musician);

    void deleteById(int id);

}
