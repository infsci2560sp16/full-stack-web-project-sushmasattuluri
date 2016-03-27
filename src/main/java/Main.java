import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import com.google.gson.Gson;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");

  /* get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
      */

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  /*  get("/", (request, response) -> {
/*
     Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello World!");



            /*     ArrayList<String> users_list = new ArrayList<String>();
                 users_list.add("tenthousand");
                users_list.add("twentythousand");


                Map<String, Object> attributes = new HashMap<>();
                 attributes.put("messages", users_list);



                  return new ModelAndView(attributes, "users.ftl");
               }, new FreeMarkerEngine());

*/
get("/", (req, res) -> {
             ArrayList<String> users = new ArrayList<String>();
             users.add("John Doe");
             users.add("Tony Doe");


             Map<String, Object> attributes = new HashMap<>();
             attributes.put("users", users);


             attributes.put("message", "The more you invest ,the less you pay for fees.");


              return new ModelAndView(attributes, "users.ftl");
           }, new FreeMarkerEngine());

           Gson gson = new Gson();

   get("/home", (req, res) -> {
                    Map<String, Object> data = new HashMap<>();
                    data.put("title", "Professor");
                    data.put("name", "Brian");
                    data.put("description", "INFSCI 2560");
                    data.put("profession", "Education");
                    return data;
                }, gson::toJson);

  /*  get("/api/time/now", (req, res) -> {
                      Map<String, Object> data = new HashMap<>();
                      data.put("currentTime", new Date());
                      return data;
                  }, gson::toJson);

    get("/api/time/now.xml", (req, res) -> {
                      Map<String, Object> data = new HashMap<>();
                      data.put("currentTime", new Date());
                      return data;
                  }, gson::toJson);

*/
  }

}
