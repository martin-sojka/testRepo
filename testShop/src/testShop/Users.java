package testShop;

public class Users {
	
	private String name;
	private Integer age;
	private boolean logged;
	
	Goods goods = new Goods();
			
	public Users(String name, Integer age, boolean logged) {
		
		this.name = name;
		this.age = age;
		this.logged = logged;
			
	}
	
	
	public String getName() {
		
		return name;

	}
	
	
	public Integer getAge() {
		
		return age;
	}
	
	
	public boolean setLogged() {
		
		logged = true;
		return logged;
	}
	
	
	public boolean getLogged() {
		
		return logged;
	}
	
	
	public Integer order(Integer howMuch) {
		
		return goods.getAmount(howMuch);
				
	}
	
	
	public Integer order() {
		
		return goods.getAmount();
				
	}

}
