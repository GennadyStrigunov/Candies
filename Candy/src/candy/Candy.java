package candy;

public class Candy implements ICandy {
	
	private int flavor;

	public Candy(int flavor) {
		this.flavor = flavor;
	}
	
	@Override
	public int getCandyFlavour() {
		// TODO Auto-generated method stub
		return flavor;
	}

}
