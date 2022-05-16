package Dao;

import models.Musician;
import org.sql2o.Connection;


import java.util.List;

public class sql2oMusicianDao implements MusicianDao {
    @Override
    public void add(Musician musician) {
        String sql = "INSERT INTO musicians (name, instrument) VALUES (:name, :instrument)";
        try (Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", musician.getName())
                    .addParameter("instrument", musician.getInstrument())
                    .executeUpdate()
                    .getKey();
            musician.setId(id);
        }

    }

    @Override
    public List<Musician> getAll() {

        String sql = "SELECT * FROM musicians";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Musician.class);
        }
    }

    @Override
    public Musician findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM musicians WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Musician.class);
        }
    }

    @Override
    public void update(int id, Musician musician) {
        String sql = "UPDATE musicians SET name = :name, instrument = :instrument WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", musician.getName())
                    .addParameter("instrument", musician.getInstrument())
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM musicians WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}

