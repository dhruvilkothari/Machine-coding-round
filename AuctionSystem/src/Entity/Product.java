package Entity;

import java.time.LocalDateTime;

public class Product {
    private final Long id;
    private final String name;
    private final String desc;
    private final int price;
    private int soldPrice;
    private final Long user;
    private final LocalDateTime dueDate;
    private final LocalDateTime startDate;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Long getUser() {
        return user;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Product(Long id, String name, String desc, int price, Long user, LocalDateTime dueDate, LocalDateTime startDate) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.user = user;
        this.dueDate = dueDate;
        this.startDate = startDate;
    }
}
