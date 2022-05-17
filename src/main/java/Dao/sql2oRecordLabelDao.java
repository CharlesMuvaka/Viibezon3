package Dao;

import models.Musician;
import models.RecordLabel;
import org.sql2o.Connection;


import java.util.List;

public class sql2oRecordLabelDao implements RecordLabelDao {



    @Override
    public void add(RecordLabel recordLabel) {
        String sql = "INSERT INTO record_labels (name, location,manager) VALUES (:name, :location,:manager)";
        try (Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", recordLabel.getName())
                    .addParameter("location", recordLabel.getLocation())
                    .addParameter("manager",recordLabel.getManager())
                    .executeUpdate()
                    .getKey();
            recordLabel.setId(id);
        }
    }

    @Override
    public List<RecordLabel> getAll() {
        String sql = "SELECT * FROM record_labels";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(RecordLabel.class);
        }
    }

    @Override
    public RecordLabel findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM record_labels WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(RecordLabel.class);
        }
    }

    @Override
    public void update(int id, RecordLabel recordLabel) {
        String sql = "UPDATE record_labels SET name = :name, location = :location, manager=:manager WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", recordLabel.getName())
                    .addParameter("location", recordLabel.getLocation())
                    .addParameter("manager",recordLabel.getManager())
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM record_labels WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }

    @Override
    public List<Musician> getAllMusician( int id) {
        String sql = "SELECT * FROM musicians Where recordlabelid = :id";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Musician.class);
        }
    }


}


