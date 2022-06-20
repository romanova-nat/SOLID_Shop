public class Product {
    private String name;
    private int price;
    private String madeIn;
    private ExpirationDate month;
    private int expirationDateYear;

    public Product(String name, int price, String madeIn, ExpirationDate month, int expirationDateYear) {
        this.name = name;
        this.price = price;
        this.madeIn = madeIn;
        this.month = month;
        this.expirationDateYear = expirationDateYear;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public ExpirationDate getMonth() {
        return month;
    }

    public int getExpirationDateYear() {
        return expirationDateYear;
    }

    @Override
    public String toString() {
        return name + ", цена = " + price + " руб./шт.";
    }
}

