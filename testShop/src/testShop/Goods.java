package testShop;

public class Goods {
	
	private static Integer amount = 20;
	
	public Goods() {
						
	}
	
	protected Integer getAmount(Integer amount) {
		
		Goods.amount -= amount;
		return Goods.amount;
	}
	
	protected Integer getAmount() {
		
		if (amount <= 0) {
			System.exit(1);
			return amount;
		}
		else
		return amount;
	}
	
	protected void addAmount(Integer add) {
		
		amount += add;
	}

}
