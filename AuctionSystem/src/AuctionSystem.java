import Entity.Product;
import Entity.User;
import Repository.ProductRepository;
import Repository.UserRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AuctionSystem {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private HashMap<Long, Auction>currentAuctions;
    private AtomicLong userId  = new AtomicLong(1);
    private AtomicLong prductId = new AtomicLong(1);

    public AuctionSystem(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        currentAuctions = new HashMap<>();
    }

    public Long registerUser(String name){
        User user = new User(userId.incrementAndGet(), name);
        return user.getId();
    }
    public Long registerProduct(String name, String desc, int price, Long user, LocalDateTime dueDate, LocalDateTime startDate){
        Product product = new Product(prductId.incrementAndGet(), name, desc, price, user, dueDate, startDate);
        return product.getId();
    }

    public void createAuction(){
        Auction auction = new Auction();
    }



}
