import dao.sql2oMusicianDao;
import dao.sql2oRecordLabelDao;
import models.Musician;
import models.RecordLabel;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
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






    }
}
