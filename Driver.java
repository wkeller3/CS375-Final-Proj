//Will Keller
//CS 375 Presentation

import java.util.*;

public class Driver {
	
	public static void main(String[] args) {
		Item empty = new Item(0,0);
		//c = 10, w = 1-c, p = 1-100, numItems = 10,100,1000,10000,100000
		int seed = 1;
		int numItems = 0;
		int capacity = 0;
		Random rand = new Random(seed);
		for(int k = 10; k <= 1000; k = k*10){
			capacity = k;
			System.out.println("********************Capacity: " + capacity + "********************");
			System.out.println("********************Weight: 1-" + capacity + "********************");
			for(int j = 10; j <= 100000; j = j*10){
				numItems = j;
				ArrayList<Item> sizeSmall = new ArrayList<Item>();
				sizeSmall.add(empty);	//need to add Item with profit = 0 and weight = 0 to be the root node
				for(int i = 0; i < numItems; i++){
					Item temp = new Item(rand.nextInt(capacity)+1,rand.nextInt(100)+1);
					sizeSmall.add(temp);
				}
				long sortTimeStart = System.nanoTime();
				Collections.sort(sizeSmall);
				long sortTimeEnd = System.nanoTime();
				long sortTime = sortTimeEnd - sortTimeStart;
				Item small[] = new Item[sizeSmall.size()];
				sizeSmall.toArray(small);
				Backtracking test = new Backtracking(small,capacity);
				long startTime = System.nanoTime();
				test.backtrack(0,0,0);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Number of items: " + numItems);
				System.out.println("Max profit: " + test.maxprofit);
				System.out.println("Execution Time (Nanoseconds): " + timeElapsed + " nanoseconds");
				double seconds = (double)timeElapsed / 1_000_000_000.0;
				System.out.println("Execution Time (Seconds): " + seconds + " seconds");
				double sortSeconds = (double)sortTime / 1_000_000_000.0;
				System.out.println("Execution Time Including Sort (Nanoseconds): " + (timeElapsed+sortTime) + " nanoseconds");
				System.out.println("Execution Time Including Sort (Seconds): " + (seconds+sortSeconds) + " seconds");
				System.out.println();
			}
		}
		
		//////////////////////////////TESTS//////////////////////////////
		
		/*Item i0 = new Item(0,0);
		Item i1 = new Item(2,40);
		Item i2 = new Item(5,30);
		Item i3 = new Item(10,50);
		Item i4 = new Item(5,10);
		Item items[] = {i0,i1,i2,i3,i4};
		Backtracking test = new Backtracking(items,16);
		test.backtrack(0,0,0);
		System.out.println(test.maxprofit);
		for(int i = 1; i <= test.numbest; i++){
			System.out.println(test.bestset[i]);
		}*/
		
		/*System.out.println();
		Item i5 = new Item(10,60);
		Item i6 = new Item(20,100);
		Item i7 = new Item(30,120);
		Item items2[] = {i0, i5, i6, i7};
		Backtracking test2 = new Backtracking(items2,50);
		test2.backtrack(0,0,0);
		System.out.println(test2.maxprofit);
		for(int i = 1; i <= test2.numbest; i++){
			System.out.println(test2.bestset[i]);
		}*/
		
		
		/*System.out.println();
		ArrayList<Item> items3 = new ArrayList<Item>();
		items3.add(i0);
		items3.add(i2);
		items3.add(i1);
		items3.add(i4);
		items3.add(i3);
		Collections.sort(items3);
		Item items4[] = new Item[items3.size()];
		items3.toArray(items4);
//		Backtracking test3 = new Backtracking(items4,50);
//		test3.backtrack(0,0,0);
//		System.out.println(test3.maxprofit);
//		for(int i = 1; i <= test3.numbest; i++){
//			System.out.println(test3.bestset[i]);
//		}
		for(int i = 0; i < items3.size(); i++){
			System.out.println(items3.get(i).getProfit());
		}*/
		
//		Item i1 = new Item(382745,825594);
//		Item i2 = new Item(799601,1677009);
//		Item i3 = new Item(909247,1676628);
//		Item i4 = new Item(729069,1523970);
//		Item i5 = new Item(467902,943972);
//		Item i6 = new Item(44328,97426);
//		Item i7 = new Item(34610,69666);
//		Item i8 = new Item(698150,1296457);
//		Item i9 = new Item(823460,1679693);
//		Item i10 = new Item(903959,1902996);
//		Item i11 = new Item(853665,1844992);
//		Item i12 = new Item(551830,1049289);
//		Item i13 = new Item(610856,1252836);
//		Item i14 = new Item(670702,1319836);
//		Item i15 = new Item(488960,953277);
//		Item i16 = new Item(951111,2067538);
//		Item i17 = new Item(323046,675367);
//		Item i18 = new Item(446298,853655);
//		Item i19 = new Item(931161,1826027);
//		Item i20 = new Item(31385,65731);
//		Item i21 = new Item(496951,901489);
//		Item i22 = new Item(264724,577243);
//		Item i23 = new Item(224916,466257);
//		Item i24 = new Item(169684,369261);
//		ArrayList<Item> testing = new ArrayList<Item>();
//		testing.add(empty);
//		testing.add(i1);
//		testing.add(i2);
//		testing.add(i3);
//		testing.add(i4);
//		testing.add(i5);
//		testing.add(i6);
//		testing.add(i7);
//		testing.add(i8);
//		testing.add(i9);
//		testing.add(i10);
//		testing.add(i11);
//		testing.add(i12);
//		testing.add(i13);
//		testing.add(i14);
//		testing.add(i15);
//		testing.add(i16);
//		testing.add(i17);
//		testing.add(i18);
//		testing.add(i19);
//		testing.add(i20);
//		testing.add(i21);
//		testing.add(i22);
//		testing.add(i23);
//		testing.add(i24);
//		Collections.sort(testing);
//		Item i[] = new Item[testing.size()];
//		testing.toArray(i);
//		Backtracking b = new Backtracking(i,6404180);
//		b.backtrack(0, 0, 0);
//		System.out.println(b.maxprofit);
		//for(int j = 1; j <= b.numbest; j++){
		//	System.out.println(b.bestset[j]);
		//}
		
	}

}
