import java.util.ArrayList;
import java.util.List;

public class FlowerService {
	private List<Flower> flowers = new ArrayList<Flower>();
	FlowerService(){
		flowers.add(new Flower("1","rose"));
		flowers.add(new Flower("2","orchid"));
	}


	  // returns a list of all flowers
	  public List<Flower> getAllFlowers() {
		  return flowers;
	  }

	  // returns a single flowers by id
	  public Flower getUser(String id) {
		  for(int i = 0; i<flowers.size();i++){
			  if(flowers.get(i).getId()==id){
				  return flowers.get(i);
			  }
		  }
		  return null;
	  }

	  // creates a new flowers
	  public Flower createFlower(String id, String name) {
		return new Flower(id,name);

	  }

	  // updates an existing flowers
	  public Flower updateFlower(String id, String name) {
		  Flower f = null;
		  for(int i = 0; i<flowers.size();i++){
			  if(flowers.get(i).getId()==id){
				  flowers.get(i).setId(id);
				  flowers.get(i).setName(name);
				  f=flowers.get(i);
			  }
		  }

		  return f;
	  }
}
