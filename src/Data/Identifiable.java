package Data;

abstract public class Identifiable {
    final String id;

    public Identifiable(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
