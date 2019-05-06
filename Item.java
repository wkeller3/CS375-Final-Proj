
public class Item implements Comparable<Item>{
	private int profit;
	private int weight;
	
	public Item(int weight, int profit){
		this.profit = profit;
		this.weight = weight;
	}
	
	public int getProfit() {
		return profit;
	}
	
	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Item other) {
		if(other.getProfit() == 0 && other.getWeight() == 0){
			return 1;
		}
		if(((float)other.getProfit())/((float)other.getWeight()) > ((float)this.getProfit())/((float)this.getWeight())){
			return 1;
		} else if(((float)other.getProfit())/((float)other.getWeight()) == ((float)this.getProfit())/((float)this.getWeight())){
			return 0;
		}
		return -1;
	}
}
