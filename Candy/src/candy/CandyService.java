package candy;

import java.util.ArrayDeque;
import java.util.Random;

public class CandyService extends CandyServiceBase implements ICandy, ICandyEater, Runnable {
	
	ArrayDeque<ICandy> candies = new ArrayDeque<ICandy>();
	
	public CandyService(ICandyEater[] candyEaters) {
		super(candyEaters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCandy(ICandy candy) {
		// TODO Auto-generated method stub
		candies.add(candy);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandyService[] candyService = new CandyService[3];
		for (int i=0; i<3; i++)
			candyService[i] = new CandyService(candyService);
	}

	@Override
	public void eat(ICandy candy) throws Exception {
		Thread.currentThread();
		// TODO Auto-generated method stub
		Thread.sleep(2000);
	}

	@Override
	public int getCandyFlavour() {
		int min = 1;
		int max = 7;
		int diff = max - min;
		Random random = new Random();
		int i = random.nextInt(diff + 1);
		i += min;		
		return i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}