package p02BookShop;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price){
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    protected Book(String author, String title){
        this.setAuthor(author);
        this.setTitle(title);
    }

    protected String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author){
        String[] authorNames = author.split("\\s+");
        if (authorNames.length == 2 && authorNames[1].charAt(0) >= 48 && authorNames[1].charAt(0) <= 57){
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected String getTitle() {
        return this.title;
    }

    private void setTitle(String title){
        if (title.length() < 3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected double getPrice() {
        return this.price;
    }

    protected void setPrice(double price){
        if (price <= 0){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nTitle: %s%nAuthor: %s%nPrice: %.1f%n",
                this.getClass().getSimpleName(),
                this.getTitle(),
                this.getAuthor(),
                this.getPrice()
                );
    }
}
