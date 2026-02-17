package Entity;
import Enum.OrderStatus;

import java.util.List;

public class Order {
    private final Long orderId;
    private final Long userId;
    private final List<OrderItem> orderItems;
    private final int price;
    private OrderStatus orderStatus;
    public Order(Long orderId, Long userId, List<OrderItem> orderItems, int price) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = orderItems;
        this.price = price;
        this.orderStatus = OrderStatus.PENDING;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getPrice() {
        return price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
