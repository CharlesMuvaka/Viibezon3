import dao.sql2oMusicianDao;
import dao.sql2oRecordLabelDao;
import dao.sql2oSongDao;
import models.Musician;
import models.RecordLabel;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {

    static sql2oMusicianDao musicianDao = new sql2oMusicianDao();
    sql2oRecordLabelDao recordLabelDao = new sql2oRecordLabelDao();
    sql2oSongDao songDao = new sql2oSongDao();

    public static void main(String[] args) {
        staticFileLocation("/public");

        //get the index page
        get("/",(request, response)->{
            Map<String, Object> templateData = new HashMap<>();
            return new ModelAndView(templateData, "index.hbs");

        }, new HandlebarsTemplateEngine());


        //get all musicians
        get("/artists",(request, response)->{
            Map<String, Object> templateData = new HashMap<>();
            sql2oMusicianDao dao = new sql2oMusicianDao();
            List<Musician> allMusicians = dao.getAll();
            System.out.println(allMusicians);

            templateData.put("artists", allMusicians);

            return new ModelAndView(templateData, "artists.hbs");
        }, new HandlebarsTemplateEngine());

        //get all record Labels
        get("/labels",(request, response)->{
            Map<String, Object> templateData = new HashMap<>();
            sql2oRecordLabelDao dao = new sql2oRecordLabelDao();
            List<RecordLabel> allLabels = dao.getAll();


            templateData.put("labels", allLabels);

            return new ModelAndView(templateData, "labels.hbs");
        }, new HandlebarsTemplateEngine());

        //get Musicians form
        get("/artistForm",(request, response)->{
            Map<String, Object> templateData = new HashMap<>();


            return new ModelAndView(templateData, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/artistForm",(request, response)->{
            Map<String, Object> templateData = new HashMap<>();
            String name = request.queryParams("name");
            String instrument = request.queryParams("instrument");
            String imageUrl = request.queryParams("imageUrl");
            int recordLabel = Integer.parseInt(request.queryParams("label"));
            String artistType = request.queryParams("artistType");


            musicianDao.add(new Musician(name, instrument,imageUrl,recordLabel, artistType));

            return new ModelAndView(templateData, "success.hbs");
        }, new HandlebarsTemplateEngine());






    }
}
