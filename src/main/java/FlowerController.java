import static spark.Spark.*;
import spark.*;
import com.google.gson.Gson;

public class FlowerController {

  public FlowerController(final FlowerService flowerService) {

    get("/flowers", new Route() {
      @Override
      public Object handle(Request request, Response response) {
        // process request
        return new Gson().toJson(flowerService.getAllFlowers());
      }
    });

    // more routes
  }
}
