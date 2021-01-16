import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class BSTDictionary implements DictionaryInterface {
	public TreeMap<String, String> treeMap;
	
	public BSTDictionary() {
		treeMap = new TreeMap<String, String>();
	}
	
	@Override
	public void addItem(String line) {
		int i = line.indexOf(" ");
		String entry = line.substring(0, i);
		String definition = line.substring(i+1);
		treeMap.put(entry, definition);
	}

	@Override
	public void removeItem(String entry) {
		treeMap.remove(entry);
	}

	@Override
	public String lookup(String s) {
		return treeMap.get(s);
	}

	@Override
	public void saveAll() throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/zt9916nr/Desktop/chatdictionaryBST.txt"));
		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
	        String value = entry.getValue();
	        String key = entry.getKey();
	        writer.write(key + " " + value + "\n");
		}
		writer.close();
		
	}
	
}
