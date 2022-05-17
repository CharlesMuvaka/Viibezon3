import Dao.sql2oMusicianDao;
import models.Musician;

public class App {
    public static void main(String[] args) {
        sql2oMusicianDao dao = new sql2oMusicianDao();
        Musician musician = new Musician("Tim","Trumpet","Instrumentalist",1 ,"Rock");
        dao.add(musician);
    }
}
