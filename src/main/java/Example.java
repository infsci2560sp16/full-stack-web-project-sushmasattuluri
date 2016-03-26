
import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class Example
{
    public static void main( String[] args) {
        get("/posts", (req, res) -> {
            return "Hello Sparkingly World!";
        });
    }
}
