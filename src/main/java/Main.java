import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import com.google.gson.Gson;

import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.Request;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    Gson gson = new Gson();

    new StockController(new StockService());
   SignIn S=new SignIn();

    get("/users", (req, res) -> {
                 ArrayList<String> users = new ArrayList<String>();
                 users.add("belowtenthousand");
                 users.add("abovetenthousand");
                 Map<String, Object> attributes = new HashMap<>();
                 attributes.put("users", users);
                 attributes.put("message", "The more you invest ,the less you pay for fees.");
                  return new ModelAndView(attributes, "users.ftl");
               }, new FreeMarkerEngine());

       get("/about", (req, res) -> {

                       Connection connection = null;
                       // res.type("application/xml"); //Return as XML

                       Map<String, Object> attributes = new HashMap<>();
                       try {


                           String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
                           xml += "<About>";

                               xml += "<Branch>";
                               xml += "<Name>Orchid Flower</Name>";
                               xml += "<Profession>Retailer</Profession>";
                               xml += "<Since>2016</Since>";
                               xml += "<Country>United States</Country>";
                               xml += "<State>Pennsylvania</State>";
                               xml += "<City>Pittsburgh</City>";
                               xml += "<OpenHour>9am-8pm</OpenHour>";
                               xml += "<Phone>111-222-3333</Phone>";
                               xml += "<Email>huz26@pitt.edu</Email>";
                               xml += "<Address>4200 Fifth Ave</Address>";
                               xml += "</Branch>";

                           xml += "</About>";
                           res.type("text/xml");
                           return xml;

                       } catch (Exception e) {
                           attributes.put("message", "There was an error: " + e);
                           return attributes;
                       } finally {
                           if (connection != null) try{connection.close();} catch(SQLException e){}
                       }
                   });


  //      //POST JSON
  //                      post("api/register", (req, res) -> {
  //                            Connection connection = null;
  //                            //Testing
  //                            System.out.println(req.body());
  //                          try {
  //                            connection = DatabaseUrl.extract().getConnection();
  //                            JSONObject obj = new JSONObject(req.body());
  //                            String username = obj.getString("username");
  //                            String password = obj.getString("password");
  //                            String email = obj.getString("email");
  //                            String fname = obj.getString("fname");
  //                            String lname = obj.getString("lname");
  //
  //                            String sql = "INSERT INTO users VALUES ('"+ username + "','" + password + "','" + email + "','" + fname + "','"+ lname + "')";
  //
  //                            connection = DatabaseUrl.extract().getConnection();
  //                            Statement stmt = connection.createStatement();
  //                            stmt.executeUpdate(sql);
  //
  //                            ResultSet rs = stmt.executeQuery("SELECT * FROM users where username ='" + username + "'");
  //                            Map<String, Object> currentuser = new HashMap<>();
  //
  //                  					currentuser.put("username", rs.getString("username"));
  //                  					currentuser.put("email", rs.getString("email"));
  //
  //                            return currentuser;
  //                          //  return req.body();
  //                          } catch (Exception e) {
  //                            return e.getMessage();
  //                          } finally {
  //                            if (connection != null) try{connection.close();} catch(SQLException e){}
  //                          }
  //                        });
  //
  //   //get("/hello", (req, res) -> "Hello World");
  //
  // /* get("/", (request, response) -> {
  //           Map<String, Object> attributes = new HashMap<>();
  //           attributes.put("message", "Hello World!");
  //           return new ModelAndView(attributes, "index.ftl");
  //       }, new FreeMarkerEngine());
  //     */
  //
  //   get("/db", (req, res) -> {
  //     Connection connection = null;
  //     Map<String, Object> attributes = new HashMap<>();
  //     try {
  //       connection = DatabaseUrl.extract().getConnection();
  //
  //       Statement stmt = connection.createStatement();
  //       stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
  //       stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
  //       ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
  //
  //       ArrayList<String> output = new ArrayList<String>();
  //       while (rs.next()) {
  //         output.add( "Read from DB: " + rs.getTimestamp("tick"));
  //       }
  //
  //       attributes.put("results", output);
  //       return new ModelAndView(attributes, "db.ftl");
  //     } catch (Exception e) {
  //       attributes.put("message", "There was an error: " + e);
  //       return new ModelAndView(attributes, "error.ftl");
  //     } finally {
  //       if (connection != null) try{connection.close();} catch(SQLException e){}
  //     }
  //   }, new FreeMarkerEngine());

  // //  POST JSON
  //   post("api/register", (req, res) -> {
  //         Connection connection = null;
  //         //Testing
  //         System.out.println(req.body());
  //       try {
  //         connection = DatabaseUrl.extract().getConnection();
  //         JSONObject obj = new JSONObject(req.body());
  //
  //        String username= obj.getString("username");
  //        String password = obj.getString("password");
  //         String email = obj.getString("email");
  //         String fname = obj.getString("fname");
  //         String lname = obj.getString("lname");
  //         String gender = obj.getString("gender");
  //         String language = obj.getString("language");
  //         String planguage = obj.getString("planguage");
  //         String topic = obj.getString("topic");
  //
  //         String sql = "INSERT INTO users (username,password) VALUES ('"+ username + "','" + password + "')";
  //
  //         connection = DatabaseUrl.extract().getConnection();
  //         Statement stmt = connection.createStatement();
  //         stmt.executeUpdate(sql);
  //
  //          ResultSet rs = stmt.executeQuery("SELECT * FROM users where username ='" + username + "'");
  //         Map<String, Object> currentuser = new HashMap<>();
  //
	// 			 	 currentuser.put("username", rs.getString("username"));
	// 			// 	// currentuser.put("email", rs.getString("email"));
  //
  //           return currentuser;
  //       //return req.body();
  //       } catch (Exception e) {
  //         return e.getMessage();
  //       } finally {
  //         if (connection != null) try{connection.close();} catch(SQLException e){}
  //       }
  //     });



   //
   //
  //  get("/api/home", (req, res) -> {
  //                   Map<String, Object> data = new HashMap<>();
  //                   data.put("title", "Professor");
  //                   data.put("name", "Brian");
  //                   data.put("description", "INFSCI 2560");
  //                   data.put("profession", "Education");
  //                   return data;
  //               }, gson::toJson);
   //
   //
  //   get("/api/about", (req, res) -> {
  //                               Map<String, Object> data = new HashMap<>();
  //                               data.put("title", "sport1");
  //                               data.put("content", "Brian1");
  //
  //                               return data;
  //                           }, gson::toJson);
   //
   //

    //
    // get("/api/time/now", (req, res) -> {
    //                   Map<String, Object> data = new HashMap<>();
    //                   data.put("currentTime", new Date());
    //                   return data;
    //               }, gson::toJson);

  /*  get("/api/time/now.xml", (req, res) -> {
                      Map<String, Object> data = new HashMap<>();
                      data.put("currentTime", new Date());
                      return data;
                  }, gson::toJson);

*/
  }

}
