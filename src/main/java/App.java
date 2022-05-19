import dao.sql2oMusicianDao;
import dao.sql2oRecordLabelDao;
import dao.sql2oSongDao;
import models.Musician;
import models.RecordLabel;
import models.Song;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

import static spark.route.HttpMethod.post;

public class App {

    static sql2oMusicianDao musicianDao = new sql2oMusicianDao();
    static sql2oRecordLabelDao recordLabelDao = new sql2oRecordLabelDao();
    static sql2oSongDao songDao = new sql2oSongDao();

    public static void main(String[] args) {
        staticFileLocation("/public");

        //get the index page
        get("/", (request, response) -> {
            Map<String, Object> templateData = new HashMap<>();
            return new ModelAndView(templateData, "index.hbs");

        }, new HandlebarsTemplateEngine());


        //get all musicians
        get("/artists", (request, response) -> {
            Map<String, Object> templateData = new HashMap<>();
            sql2oMusicianDao dao = new sql2oMusicianDao();
            List<Musician> allMusicians = dao.getAll();
            // System.out.println(allMusicians);
            templateData.put("artists", allMusicians);
            return new ModelAndView(templateData, "artists.hbs");
        }, new HandlebarsTemplateEngine());

        //get all record Labels
        get("/labels", (request, response) -> {
            Map<String, Object> templateData = new HashMap<>();
            sql2oRecordLabelDao dao = new sql2oRecordLabelDao();
            List<RecordLabel> allLabels = dao.getAll();


            templateData.put("labels", allLabels);

            return new ModelAndView(templateData, "labels.hbs");
        }, new HandlebarsTemplateEngine());

        //////////////////////////////////MUSICIAN//////////////////////////////////////
        get("/artistForm", (request, response) -> {
            Map<String, Object> templateData = new HashMap<>();
            List<RecordLabel> labels = recordLabelDao.getAll();
            templateData.put("labels", labels);

            return new ModelAndView(templateData, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/artistForm", (request, response) -> {
            Map<String, Object> templateData = new HashMap<>();
            String name = request.queryParams("name");
            String instrument = request.queryParams("instrument");
            //String imageUrl = request.queryParams("imageUrl");
            int recordLabel = Integer.parseInt(request.queryParams("label"));
            String artistType = request.queryParams("artistType");
            String genre = request.queryParams("genre");
            Musician musician = new Musician(name, instrument, artistType, recordLabel, genre);
            musician.setAvatarUrl("/images/soon2.jpeg");
            musicianDao.add(musician);
            response.redirect("/artists");
            return null;
        }, new HandlebarsTemplateEngine());

        get("update-artist/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Map<String, Object> model = new HashMap<String, Object>();
            boolean update = true;
            boolean position = true;
            model.put("id", id);
            model.put("update", update);
            model.put("position", position);
            return modelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/update-label/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            String name = request.queryParams("name");
            String instrument = request.queryParams("instrument");
            // String imageUrl = request.queryParams("imageUrl");
            int recordLabel = Integer.parseInt(request.queryParams("label"));
            String artistType = request.queryParams("artistType");
            String genre = request.queryParams("genre");
            Musician musician = new Musician(name, instrument, artistType, recordLabel, genre);
            musician.setAvatarUrl("/images/soon2.jpeg");
            musicianDao.update(id, musician);
            response.redirect("/artists");
            return null;
        }, new HandlebarsTemplateEngine());

        get("delete-artist/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            musicianDao.deleteById(id);
            response.redirect("/artists");
            return null;
        }, new HandlebarsTemplateEngine());

        ////////////////////////LABEL////////////////////////////////
        get("/labelform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return modelAndView(model, "labelform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/labelform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            String manager = request.queryParams("manager");
            RecordLabel label = new RecordLabel(name, location, manager);
            label.setAvatarUrl("/images/soon2.jpeg");
            recordLabelDao.add(label);
            response.redirect("/labels");
            return null;
        });
        get("update-label/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Map<String, Object> model = new HashMap<String, Object>();
            boolean update = true;
            model.put("id", id);
            boolean position = true;
            model.put("position", position);
            model.put("update", update);
            return modelAndView(model, "labelform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/update-label/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            String manager = request.queryParams("manager");
            RecordLabel label = new RecordLabel(name, location, manager);
            label.setAvatarUrl("/images/soon2.jpeg");
            recordLabelDao.update(id, label);
            response.redirect("/labels");
            return null;
        }, new HandlebarsTemplateEngine());

        get("delete-label/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            recordLabelDao.deleteById(id);
            response.redirect("/labels");
            return null;
        }, new HandlebarsTemplateEngine());


        ///////////////////SONGS///////////////////////////////////

        get("/songform/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Map<String, Object> model = new HashMap<String, Object>();
            Musician artists = musicianDao.findById(id);
            model.put("artists", artists);
            boolean position = true;
            model.put("form",position);
            model.put("id",id);
            return modelAndView(model, "songform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/songform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String title = request.queryParams("title");
            String genre = request.queryParams("genre");
            int artistsid = Integer.parseInt(request.queryParams("artist"));
            Song song = new Song(title, genre, artistsid);
            //label.setAvatarUrl("/images/soon2.jpeg");
            songDao.add(song);
            response.redirect("/artist/"+artistsid);
            return null;
        });
        get("update-song/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Map<String, Object> model = new HashMap<String, Object>();
            boolean update = true;
            model.put("id", id);
            model.put("update", update);
            boolean position = true;
            model.put("position", position);
            Musician artist = musicianDao.findById(songDao.findById(id).getMusicianid());
            model.put("artist",artist);
            return modelAndView(model, "songform.hbs");

        }, new HandlebarsTemplateEngine());

        post("/update-song/:id", (request, response) -> {
           // int id = Integer.parseInt(request.params("id"));
            String title = request.queryParams("title");
            String genre = request.queryParams("genre");
            int artistsid = Integer.parseInt(request.queryParams("artist"));
            int songid =  Integer.parseInt(request.queryParams("songid"));
            System.out.println(songid);
            Song song = new Song(title, genre, artistsid);
            songDao.update(songid,song);

            response.redirect("/artist/"+artistsid);
            return null;
        }, new HandlebarsTemplateEngine());

        get("delete-song/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            songDao.deleteById(id);
            response.redirect("/artists");
            return null;
        }, new HandlebarsTemplateEngine());

////////////////////////////individual artist///////////////////////////

        get("artist/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Map<String, Object> model = new HashMap<String, Object>();
            Musician musician = musicianDao.findById(id);
            List<Song> song = musicianDao.getAllSongs(id);
            model.put("song",song);
            model.put("artist", musician);
            boolean position = true;
            model.put("position", position);
            return modelAndView(model,"oneartist.hbs");
        }, new HandlebarsTemplateEngine());

//////////////////////////////individualSong/////////////////////////
        get("song/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Map<String, Object> model = new HashMap<String, Object>();
            Song song = songDao.findById(id);
            String musician = musicianDao.findById(song.getMusicianid()).getName();
            int artistid =  musicianDao.findById(song.getMusicianid()).getId();
           // List<Song> song = musicianDao.getAllSongs(id);
            model.put("song",song);
            model.put("artist", musician);
            model.put("id",artistid);
            boolean position = true;
            model.put("position", position);
            return modelAndView(model,"individualsong.hbs");
        }, new HandlebarsTemplateEngine());



        ////////////////////////individual label///////////////////

        get("label/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Map<String, Object> model = new HashMap<String, Object>();
        RecordLabel label = recordLabelDao.findById(id);
            List<Musician> artists = recordLabelDao.getAllMusician(id);
            model.put("artist",artists);
            model.put("label", label);
            boolean position = true;

            model.put("update", position);
            return modelAndView(model,"onelabel.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
