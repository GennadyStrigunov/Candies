package candy;

import java.util.Random;
import java.util.Vector;

public class CandyService extends CandyServiceBase {
	
	static volatile Vector<Candy> candies = new Vector<Candy>();
	static volatile Vector<Integer> flovers = new Vector<Integer>();
	static volatile boolean isGet = false;
	final int CANDIESCOUNT = 10;
	final int CANDYEATERSCOUNT = 3;
	CandyEater[] candyEatersR = new CandyEater[CANDYEATERSCOUNT];
	
	public CandyService(ICandyEater[] candyEaters) {
		super(candyEaters);
		for (int i=0; i<CANDIESCOUNT; i++)
			addCandy(null);
		for (int i=0; i<CANDYEATERSCOUNT; i++) {
			candyEatersR[i] = new CandyEater();
			candyEatersR[i].start();
		}
		try {
			for (int i=0; i<CANDYEATERSCOUNT; i++) {
				candyEatersR[i].join();
			}
		} catch (InterruptedException ex) {
			
		}
	}

	@Override
	public void addCandy(ICandy candy) {
		int min = 1;
		int max = 7;
		int diff = max - min;
		Random random = new Random();
		int i = random.nextInt(diff + 1);
		i += min;		

		candies.add(new Candy(i));
	}

	public static synchronized Candy getNextCandy() {
		isGet = true;
		Candy candy = CandyService.candies.get(0);
		if (!flovers.contains(Integer.valueOf(candy.getCandyFlavour()))) {
			CandyService.candies.remove(candy);
			CandyService.flovers.add(candy.getCandyFlavour());
		}
		isGet = false;
		return candy;
	}
	
	public static void main(String[] args) {
		new CandyService(null);
	}
}