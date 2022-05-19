package dao;

import models.Song;

import java.util.List;

public class sql2oSongDao implements SongDao {

    @Override
    public void add(Song song) {
        String sql = "INSERT INTO songs (title, genre, musicianid) VALUES (:title,:genre,:musicianid)";
        try (var connection = db.sql2o.open()) {
            int id =(int)connection.createQuery(sql , true)
                    .bind(song)
                    .executeUpdate()
                    .getKey();
                     song.setId(id);

        }
    }

    @Override
    public List<Song> getAll() {
        String sql = "SELECT * FROM songs";
        try (var connection = db.sql2o.open()) {
            return connection.createQuery(sql)
                    .executeAndFetch(Song.class);
        }
    }

    @Override
    public Song findById(int id) {
        try (var connection = db.sql2o.open()) {
            return connection.createQuery("SELECT * FROM songs WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Song.class);
        }
    }

    @Override
    public void update(int id, Song song) {
        String sql = "UPDATE songs SET title = :title, genre = :genre, musicianid = :musicianid WHERE id = :id";
        try (var connection = db.sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("title",song.getTitle())
                    .addParameter("genre",song.getGenre())
                    .addParameter("musicianid",song.getMusicianid())
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM songs WHERE id = :id";
        try (var connection = db.sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
