import Entity.Observer;
import Entity.Product;
import Entity.Subject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Auction implements Subject {
    private final Long id;
    private Product product;
    private List<Observer>userList;
    private LocalDateTime localDateTime;

    public Auction(Long id, Product product) {
        this.id = id;
        this.product = product;
        userList = new ArrayList<>();
        this.localDateTime = product.getStartDate();
    }

    @Override
    public void addObserver(Observer observer) {
        userList.add(observer);
    }

    public void placeBid(Observer observer, int amount){

    }
    @Override
    public void removeObserver(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notifyObserver(int amount) {


    }
}
