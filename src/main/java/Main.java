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
//get json
    new StockController(new StockService());


//Using freemarker template
    get("/users", (req, res) -> {
                 ArrayList<String> users = new ArrayList<String>();
                 users.add("belowtenthousand");
                 users.add("abovetenthousand");
                 Map<String, Object> attributes = new HashMap<>();
                 attributes.put("users", users);
                 attributes.put("message", "The more you invest ,the less you pay for fees.");
                  return new ModelAndView(attributes, "users.ftl");
               }, new FreeMarkerEngine());
//get xml
       get("/about", (req, res) -> {

                       Connection connection = null;
                       // res.type("application/xml"); //Return as XML

                       Map<String, Object> attributes = new HashMap<>();
                       try {


                           String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
                           xml += "<About>";

                               xml += "<Branch>";
                               xml += "<FirstName>Jacob</FirstName>";
                               xml += "<LastName>McCarthy</LastName>";
                               xml += "<Street>35_Highland_Road</Street>";
                               xml += "<Country>United States</Country>";
                               xml += "<State>Pennsylvania</State>";
                               xml += "<City>Pittsburgh</City>";
                               xml += "<Status>Full-time</Status>";
                               xml += "<Phone>412-961-2098</Phone>";
                               xml += "<Email>VSS9@pitt.edu</Email>";
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
//get json
       get("/api/register/:firstname", (req, res) -> {
                   Map<String, Object> data = new HashMap<>();
                   String firstname=req.params("firstname");
                  // String lastname = req.params("lastname");
                  //  String username=req.queryParams("username");
                  //  String password = req.queryParams("password");
                  //  String confpassword=req.queryParams("confpassword");
                  //  String email = req.queryParams("email");
                   data.put("firstname", firstname);
                //  data.put("lastname", lastname);
                  //  data.put("username", username);
                  //  data.put("password", password);
                  //  data.put("confpassword", confpassword);
                  //  data.put("email", email);

                         return data;
                     }, gson::toJson);

         post("/api/about", (req, res) -> {
                       Map<String, Object> data = new HashMap<>();
                       data.put("content1", "Grow your savings to cover 3 to 6 months of unplanned expenses in a conservatively invested portfolio.40%stocks and 60%bonds");

                       data.put("content2", "Invest long-term with a target of $1,827,000 for an annual retirement income of $89,037. This can be a regular investment account, or an IRA account.90%stocks and 10%bonds");

                      data.put("content3", "Grow and preserve capital over time. This is an excellent goal type for unknown future needs or money you plan to pass to future generations.80%stocks and 20%bonds");

                      return data;
                        }, gson::toJson);


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
