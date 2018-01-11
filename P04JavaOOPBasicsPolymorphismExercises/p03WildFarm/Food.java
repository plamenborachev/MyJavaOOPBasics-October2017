package p03WildFarm;

public abstract class Food {
    private int quantity;

    protected Food(int quantity) {
        this.quantity = quantity;
    }

    protected int getQuantity() {
        return this.quantity;
    }
}
