package dao;

import models.Song;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class sql2oSongDaoTest {
   Connection conn;
    sql2oSongDao dao= new sql2oSongDao();

    @Before
    public void setUp() throws Exception {
        db.sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/createH2.sql'", "", "");
        conn = db.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() {
        Song song = makeSong();
        dao.add(song);
        assertEquals(song, dao.findById(song.getId()));


    }

    @Test
    public void getAll() {
        Song song = makeSong();
        Song song1 = makeSong();
        Song song3 = makeSong();
        dao.add(song);
        dao.add(song1);
        dao.add(song3);
        assertEquals(3, dao.getAll().size());
    }

    @Test
    public void findById() {
        Song song = makeSong();
        Song song1 = makeSong();
        dao.add(song);
        dao.add(song1);
        assertEquals(song1, dao.findById(song1.getId()));
    }

    @Test
    public void update() {
        Song song = makeSong();
        dao.add(song);
        song.setTitle("New Title");
        dao.update(song.getId(),song);
        assertEquals(song, dao.findById(song.getId()));
    }

    @Test
    public void deleteById() {
        Song song = makeSong();
        dao.add(song);
        dao.deleteById(song.getId());
        assertEquals(0, dao.getAll().size());
    }

    @Test
    public void deleteByIdSecondTrial() {
        Song song = makeSong();
        Song song1 = makeSong();
        Song song3 = makeSong();
        dao.add(song);
        dao.add(song1);
        dao.add(song3);
        dao.deleteById(2);
        assertEquals(song3, dao.getAll().get(1));
    }

    public Song makeSong() {
        return new Song("Song", "genre", 1);
    }
}