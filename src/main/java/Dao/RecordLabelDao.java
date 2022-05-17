package Dao;

import models.Musician;
import models.RecordLabel;

import java.util.List;
import java.util.ListIterator;

public interface RecordLabelDao {
    //CRUD
    void add(RecordLabel recordLabel);

    List<RecordLabel> getAll();

    RecordLabel findById(int id);

    void update(int id, RecordLabel recordLabel);

    void deleteById(int id);

    List<Musician> getAllMusician(int id);
}
