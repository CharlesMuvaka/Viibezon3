package Dao;

import models.RecordLabel;

import java.util.List;

public interface RecordLabelDao {
    //CRUD
    void add(RecordLabel recordLabel);

    List<RecordLabel> getAll();

    RecordLabel findById(int id);

    void update(int id, RecordLabel recordLabel);

    void deleteById(int id);
}
