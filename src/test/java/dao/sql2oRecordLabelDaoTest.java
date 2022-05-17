package dao;

import models.Musician;
import models.RecordLabel;
import models.Song;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class sql2oRecordLabelDaoTest {
    Connection conn;
    sql2oRecordLabelDao dao = new sql2oRecordLabelDao();
    sql2oMusicianDao musicianDao = new sql2oMusicianDao();

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
        RecordLabel recordLabel = makeRecordLabel();
        RecordLabel recordLabel1 = makeRecordLabel();
        RecordLabel recordLabel2 = makeRecordLabel();
        dao.add(recordLabel);
        dao.add(recordLabel1);
        dao.add(recordLabel2);
        System.out.println(recordLabel2.getId());
        System.out.println(recordLabel.getId());
        System.out.println(dao.findById(recordLabel.getId()));
        System.out.println(dao.findById(1).getId() );
        assertEquals(recordLabel, dao.findById(recordLabel.getId()));

    }

    @Test
    public void getAll() {
        RecordLabel recordLabel = makeRecordLabel();
        RecordLabel recordLabel1 = makeRecordLabel();
        RecordLabel recordLabel3 = makeRecordLabel();
        dao.add(recordLabel);
        dao.add(recordLabel1);
        dao.add(recordLabel3);
        assertEquals(3, dao.getAll().size());
    }

    @Test
    public void findById() {
        RecordLabel recordLabel = makeRecordLabel();
        dao.add(recordLabel);
        assertEquals(recordLabel, dao.findById(recordLabel.getId()));
    }

    @Test
    public void update() {
        RecordLabel recordLabel = makeRecordLabel();
        dao.add(recordLabel);
        recordLabel.setName("New Title");
        dao.update(recordLabel.getId(),recordLabel);
        assertEquals(recordLabel, dao.findById(recordLabel.getId()));
    }

    @Test
    public void deleteById() {
        RecordLabel recordLabel = makeRecordLabel();
        dao.add(recordLabel);
        dao.deleteById(recordLabel.getId());
        assertEquals(0, dao.getAll().size());
    }

    @Test
    public void getAllMusician() {
        RecordLabel recordLabel = makeRecordLabel();
        Musician musician = makeMusician();
        Musician musician1 = makeMusician();
        Musician musician3 = makeMusician();
        dao.add(recordLabel);
        musicianDao.add(musician);
        musicianDao.add(musician1);
        musicianDao.add(musician3);
        assertEquals(3, dao.getAllMusician(recordLabel.getId()).size());
    }

    public RecordLabel makeRecordLabel() {
        return new RecordLabel("Test Record Label", "123456789", "ping" );
    }

    public Musician makeMusician() {

        return new Musician("samuel", "trumpet", "instrumentalist", 1, "Rock");
    }
}