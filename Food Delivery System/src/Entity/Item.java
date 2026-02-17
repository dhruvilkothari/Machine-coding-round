package Entity;

import java.util.concurrent.locks.ReentrantLock;

public class Item {
    private final Long itemId;
    private final String name;
    private String price;
    private int quantity;
    private ReentrantLock lock = new ReentrantLock();

    public Item(Long itemId, String name, String price, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int qty){
        lock.lock();
        try{
            if(quantity<qty){
                throw new RuntimeException("Quantity cannot be reduced");
            }
            quantity-=qty;
        }catch (Exception exp){
            System.out.println("Cannot be reduced");
        }finally {
            lock.unlock();
        }
    }
}
