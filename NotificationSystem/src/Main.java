import java.util.List;

public class Main {

    public static void main(String[] args){

        NotificationObservable observable = new NotificationObservable();

        List<NotificationStrategy> strategies = List.of(
                new EmailStrategy()
                // add SmsStrategy, PushStrategy later
        );

        NotificationEngine engine = new NotificationEngine(strategies);

        observable.addObserver(engine);

        NotificationRepository repo = new NotificationRepository();

        NotificationService service =
                new NotificationService(observable, repo);

        service.send("user1", "Order placed");
        service.send("user1", "Payment failed");

        System.out.println(repo.get("user1"));
    }
}
