import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationEngine implements Observer {

    private final List<NotificationStrategy> strategies;
    private final ExecutorService executor =
            Executors.newFixedThreadPool(5);

    public NotificationEngine(List<NotificationStrategy> strategies){
        this.strategies = strategies;
    }

    @Override
    public void update(Notification notification){

        for(NotificationStrategy strategy : strategies){
            executor.submit(() -> {
                try{
                    strategy.sendNotification(notification);
                }catch(Exception e){
                    System.out.println("Failed sending: " + e.getMessage());
                }
            });
        }
    }
}
