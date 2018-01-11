package p02BookShop;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String author, String title, double price){
        super(author, title);
        this.setPrice(price);
    }

    @Override
    protected void setPrice(double price){
        super.setPrice(price*1.3);
    }
}
