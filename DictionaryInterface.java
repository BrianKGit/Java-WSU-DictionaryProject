import java.io.*;

public interface DictionaryInterface {
    public void addItem(String entry);
    public void removeItem(String entry);
    public String lookup(String s);
    public void saveAll()throws IOException;
}
