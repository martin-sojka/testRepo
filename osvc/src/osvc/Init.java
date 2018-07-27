package osvc;

import org.apache.log4j.Logger;

public class Init {
	
	static Logger log = Logger.getLogger(Init.class);

	public static void main(String[] args) {
		
		log.debug("debug log message");
		log.info("info log message");
		
		Validation validation = new Validation();
		validation.validate();
			

	}

}
