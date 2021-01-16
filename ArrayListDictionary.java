import java.util.*;
import java.io.*;

public class ArrayListDictionary implements DictionaryInterface {
    
    ArrayList<Entry> myDictionary;
    String def,name;
    
    public ArrayListDictionary() {
        myDictionary = new ArrayList<Entry>();
    }
    
    public ArrayListDictionary(String name, String def) {
    	myDictionary = new ArrayList<Entry>();
        this.name = name;
        this.def = def;
    }
    
    public void addItem(String entry){
        int i = entry.indexOf(" ");
        String e = entry.substring(0, i);
        String d = entry.substring(i+1);
        Entry input = new Entry(e, d);
        myDictionary.add(input);
    }
    
    public void removeItem(String entry){
    	
        for(int i=0; i < myDictionary.size(); i++) {
            if(myDictionary.get(i).getName().equals(entry)){
                myDictionary.remove(i);
            }
        }
    }
    
    public String lookup(String s) {
        String r = null;
        for(int i=0; i < myDictionary.size(); i++) {
            if(myDictionary.get(i).getName().equals(s)) {
                r = myDictionary.get(i).toString();
            }
            
        } 
        return r;
    }
    
    
    public void saveAll() throws IOException{
    	BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/zt9916nr/Desktop/chatdictionaryArrayList.txt"));
    	for(int i=0; i < myDictionary.size(); i++) {
            String line = myDictionary.get(i).toString() + "\n";
            writer.write(line);
            
        }
        writer.close();
    }
}
