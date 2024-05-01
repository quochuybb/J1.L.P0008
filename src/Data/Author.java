package Data;
public class Author extends Identifiable{
    private String name;

    public Author(String authorID, String name) {
        super(authorID);
        this.name = name;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
