package dao;


import models.Musician;
import models.Song;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.Assert.*;


public class sql2oMusicianDaoTest {
    sql2oMusicianDao dao = new sql2oMusicianDao();
    sql2oSongDao songDao = new sql2oSongDao();
    Connection conn;

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
    public void testAdd() throws Exception {
        Musician musician = makeMusician();
        dao.add(musician);
        assertEquals(musician, dao.findById(musician.getId()));

    }

    @Test
    public void testGetAll() {
        Musician musician = makeMusician();
        Musician musician1 = makeMusician();
        Musician musician3 = makeMusician();
        dao.add(musician);
        dao.add(musician1);
        dao.add(musician3);
        assertEquals(3, dao.getAll().size());
    }

    @Test
    public void testFindById() {
        Musician musician = makeMusician();
        Musician musician1 = makeMusician();
        dao.add(musician);
        dao.add(musician1);
        assertEquals(musician1, dao.findById(musician1.getId()));
    }

    @Test
    public void testUpdate() {
        Musician musician = makeMusician();
        dao.add(musician);
        musician.setGenre("Alternative-rock");
        dao.update(musician.getId(), musician);
        assertEquals(musician, dao.findById(musician.getId()));

    }

    @Test
    public void testDeleteById() {
        Musician musician = makeMusician();
        Musician musician1 = makeMusician();
        Musician musician3 = makeMusician();
        dao.add(musician);
        dao.add(musician1);
        dao.add(musician3);
        dao.deleteById(2);
        assertEquals(musician3, dao.getAll().get(1));
    }

    @Test
    public void testGetAllSongs() {
        Musician musician = makeMusician();
        Song song = makeSong();
        Song song1 = makeSong();
        Song song2 = makeSong();
        songDao.add(song);
        songDao.add(song1);
        songDao.add(song2);
        assertEquals(3,dao.getAllSongs(1).size());

    }

    public Musician makeMusician() {

        return new Musician("samuel", "trumpet", "instrumentalist", 1, "Rock");
    }

    public Song makeSong() {
        return new Song("Song", "genre", 1);
    }

}