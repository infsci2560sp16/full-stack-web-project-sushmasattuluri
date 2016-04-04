import java.util.ArrayList;
import java.util.List;

public class StockService {
	private List<Stock> stocks = new ArrayList<Stock>();
	StockService(){
		stocks.add(new Stock("1","Vanguard U.S. Total Stock Market Index ETF (VTI)"));
		stocks.add(new Stock("2","Vanguard US Large-Cap Value Index ETF (VTV)"));
	}


	  // returns a list of all stocks
	  public List<Stock> getAllStocks() {
		  return stocks;
	  }

	  // returns a single stock by id
	  public Stock getUser(String id) {
		  for(int i = 0; i<stocks.size();i++){
			  if(stocks.get(i).getId()==id){
				  return stocks.get(i);
			  }
		  }
		  return null;
	  }



}
