package dao;


import models.Musician;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.Assert.*;


public class sql2oMusicianDaoTest {
    sql2oMusicianDao dao= new sql2oMusicianDao();
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
        Musician musician =  makeMusician();
        dao.add(musician);
        assertEquals(musician, dao.findById(musician.getId()));

    }

    public void testGetAll() {
    }

    public void testFindById() {
    }

    public void testUpdate() {
    }

    public void testDeleteById() {
    }

    public void testGetAllSongs() {
    }

    public Musician makeMusician() {
        return new Musician("samuel","trumpet","instrumentalist",1 ,"Rock");
    }
}