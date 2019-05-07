//Will Keller
//CS 375 Presentation

public class Backtracking {
	public Item[] items;
	//public int[] include; //"yes" == 1, "no" == 0
	//public int[] bestset; //best iteration of include so far
	//public int numbest;
	public int maxprofit;
	public int c;
	
	public Backtracking(Item[] items, int c) {
		this.items = items;
		//include = new int[items.length];
		//bestset = new int[items.length];
		//numbest = 0;
		maxprofit = 0;
		this.c = c;
	}

	public double computeBound(int i, int weight, int profit){
		double bound = profit;
		//double x[] = new double[items.length];
		double x = 0.0;
		//for(int j = i; j < items.length; j++){
			//x[j] = 0.0;
		//}
		while((weight < c) && (i < items.length)){
			if(weight+items[i].getWeight() <= c){
				//x[i] = 1;
				weight = weight + items[i].getWeight();
				bound = bound + items[i].getProfit();
			} else{
				//x[i] = (double)(c-weight)/items[i].getWeight();
				x = (double)(c-weight)/items[i].getWeight();
				weight = c;
				//bound = bound + items[i].getProfit()*x[i];
				bound = bound + items[i].getProfit()*x;
			}
			i = i+1;
		}
		return bound;
	}
	
	public boolean promising(int i, int profit, int weight){
		//non-promising means that we cannot get a better solution by expanding node
		if(weight >= c){
			return false;
		}
		double bound = 0;
		bound = computeBound(i+1, weight, profit);
		return (bound > maxprofit);
	}
	
	public void backtrack(int i, int profit, int weight){
		//System.out.println(weight+"\n"+profit);
		if(weight <= c && profit >= maxprofit){
			//save better solution
			maxprofit = profit; //save new profit
			//numbest = i;
			//for(int j = 0; j < bestset.length; j++){
			//	bestset[j] = include[j];
			//}
		}
		if(promising(i, profit, weight) && i < items.length-1){
			//include[i+1] = 1;
			backtrack(i+1, profit+items[i+1].getProfit(), weight+items[i+1].getWeight());
			//include[i+1] = 0;
			backtrack(i+1, profit, weight);
		}
	}
	
}
