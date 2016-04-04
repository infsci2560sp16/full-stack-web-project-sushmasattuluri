import static spark.Spark.*;
import spark.*;
import com.google.gson.Gson;

public class StockController {

  public StockController(final StockService stockService) {

    get("/stocks", new Route() {
      @Override
      public Object handle(Request request, Response response) {
        // process request
        return new Gson().toJson(stockService.getAllStocks());
      }
    });

    // more routes
  }
}
