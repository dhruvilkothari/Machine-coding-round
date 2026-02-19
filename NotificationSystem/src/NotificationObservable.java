import java.util.ArrayList;
import java.util.List;

public class NotificationObservable implements Subject{
    private Notification notification;

    private List<Observer>observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Notification notification) {
        for (Observer obj: observers)
            obj.update(notification);


    }
    public void setNotification(Notification notification) throws InterruptedException {
        this.notification = notification;
        Thread.sleep(1000);
        notifyObservers(notification);
    }

    public Notification getNotification() {
        return notification;
    }
}
