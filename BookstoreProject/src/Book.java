public class Book extends Product{
    private String authorName;
    public Book(double pri, String nam, String authorName, int id) {
        super(pri, nam, id);
        this.authorName = authorName;
        setType("Book");
    }
}
