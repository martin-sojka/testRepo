package testShop;

public class Users {
	
	private String name;
	private Integer age;
	private boolean logged;
	
	public Users(String name, Integer age, boolean logged) {
		
		this.name = name;
		this.age = age;
		this.logged = logged;
		
		
	}
	
	protected String getName() {
		
		return name;

	}
	
	protected Integer getAge() {
		
		return age;
	}
	
	protected boolean setLogged() {
		
		logged = true;
		return logged;
	}
	
	protected boolean getLogged() {
		
		return logged;
	}

}
