public class NotificationService {

    private final NotificationObservable observable;
    private final NotificationRepository repository;

    public NotificationService(NotificationObservable observable,
                               NotificationRepository repository){
        this.observable = observable;
        this.repository = repository;
    }

    public void send(String userId, String message){

        // create base
        Notification notification = new SimpleNotification(message);

        // decorate
        notification = new TimeStampNotification(notification);

        // publish event
        observable.notifyObservers(notification);

        // store history
        repository.save(userId, notification);
    }
}
