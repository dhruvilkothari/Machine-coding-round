package Entity;

public class OrderItem {
    private String name;
    private int qty;

    public OrderItem(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
