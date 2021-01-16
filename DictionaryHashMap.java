import java.util.*;
import java.io.*;

/**
 *
 * @author nd5152wx
 */
public class DictionaryHashMap implements DictionaryInterface {
    
    //not currently doing anything with these
    final int CAPACITY = 400; //capacity of hashtable
    public static final int HASH_TABLE_SIZE = 400;
    
    HashMap<String, String> myHashMap; // Edited this line

    public DictionaryHashMap() { 
       
       myHashMap = new HashMap<String, String>();      
    }

    //add item to hashmap
    public void addItem(String line) {
        int i = line.indexOf(" ");
        String entry = line.substring(0, i);
        String definition = line.substring(i+1);
        myHashMap.put(entry, definition); 
    }

    //remove item from hashmap
    public void removeItem(String entry) {       
        myHashMap.remove(entry);
    }

    //searching method
    public String lookup(String entry) {
        //cast the return statement as a String(.get only for objects)
        return (String) myHashMap.get(entry);
    }

    //save the new entry to the file
    public void saveAll() throws IOException {
    	BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/zt9916nr/Desktop/chatdictionaryHashMap.txt"));
    	for (Map.Entry<String, String> entry : myHashMap.entrySet()) {
    	    String key = entry.getKey();
    	    Object value = entry.getValue();
    	    writer.write(key + " " + value + "\n");
    	}
		writer.close();
    	
        /*
        FileWriter fw = null;
        try {
            fw = new FileWriter("chatDictionary.txt", true);
        } catch (IOException ex) {
            Logger.getLogger(DictionaryHashMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter(bw);
        outFile.print("\n" + (String) entry + " " + (String) definition);
        //***************************

        */
    }
    

}//end class
