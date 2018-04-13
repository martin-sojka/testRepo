package cz.actum;

import org.jolokia.client.*;
import org.jolokia.client.request.*;
import java.util.Map;


public class Memtest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
			J4pClient j4p = new J4pClient("http://127.0.0.1:8778/jolokia/");
			
			J4pReadRequest req = new J4pReadRequest("java.lang:type=Runtime");
			
			J4pReadResponse resp = j4p.execute(req);
			
			Map<String,Long> vals = resp.getValue();
			
	        long used = vals.get("uptime");
	      //  long max = vals.get("max");
	        int usage = (int) (((used / 1000) / 60));
	        
	        System.out.println(usage);
		
	}

}
