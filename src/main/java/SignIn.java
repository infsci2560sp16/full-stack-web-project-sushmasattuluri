import com.google.gson.Gson;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import static spark.Spark.get;
import static spark.Spark.post;

public class SignIn {
	Gson gson=new Gson();
	public SignIn(){
		userSignin();
	}
	public void userSignin(){
    // POST JSON
    post("/register", (req, res) -> {
    Map<String, Object> data = new HashMap<>();
    String firstname=req.queryParams("firstname");
    String lastname = req.queryParams("lastname");
    String username=req.queryParams("username");
    String password = req.queryParams("password");
    String confpassword=req.queryParams("confpassword");
    String email = req.queryParams("email");
    data.put("firstname", firstname);
    data.put("lastname", lastname);
    data.put("username", username);
    data.put("password", password);
    data.put("confpassword", confpassword);
    data.put("email", email);
          return data;
      }, gson::toJson);
}
