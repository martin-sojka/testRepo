package cz.codes;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HshMap {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
			hmap.put(1, "AB");
			hmap.put(2, "CD");
			hmap.put(3, "EF");
			hmap.put(4, "GH");
			hmap.put(5, "IJ");
			hmap.put(6, "KL");
			
			try {
				FileOutputStream fos = new FileOutputStream("hashmap.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(hmap);
				oos.close();
				fos.close();
				System.out.println("Serialized HashMap data is saved in hashmap.ser");
				
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
		HashMap<Integer, String> hmap2 = null;
		
		try {
			FileInputStream fis = new FileInputStream("hashmap.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			hmap2 = (HashMap<Integer, String>) ois.readObject();
			ois.close();
			fis.close();
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
			return;
			
		}catch(ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
		
		System.out.println("Deserialized HashMap..");
		
		Set<Entry<Integer, String>> set = hmap2.entrySet();
		Iterator<Entry<Integer, String>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry<Integer, String> mentry = iterator.next();
				System.out.print("key: "+ mentry.getKey() + " & Value: ");
		        System.out.println(mentry.getValue());
			}
			

	}

}
