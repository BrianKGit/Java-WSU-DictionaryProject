
public class Entry {
    
    String name, def;
    
    public Entry(){
        
    }
    
    public Entry(String name, String def) {
        this.name = name;
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    @Override
    public String toString() {
        return name + " " + def;
    }
    
    
    
}
