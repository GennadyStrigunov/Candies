package candy;

class CandyEater extends Thread implements ICandyEater {
	
	public CandyEater() {
		System.out.println("Start " + this.getName());
	}
	
	@Override
	public void eat(ICandy candy) throws Exception {
		if (candy == null)
			return;
		System.out.println("Process " + this.getName() + " " + candy.hashCode());
		Thread.sleep(2000);
		CandyService.flovers.remove(Integer.valueOf(candy.getCandyFlavour()));
	}

	@Override
	public void run() {
		while (true) {
			if (CandyService.candies.isEmpty()) {
				System.out.println("End " + this.getName());
				return;
			}
			try {
				if (!CandyService.isGet)
					eat(CandyService.getNextCandy());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
