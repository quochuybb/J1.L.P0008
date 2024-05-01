package Data;

public class Book extends Identifiable{
    private float price;
    private String title;
    private Author author;
    public Book(String id, float price,String title,Author author){
        super(id);
        this.price = price;
        this.title = title;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
