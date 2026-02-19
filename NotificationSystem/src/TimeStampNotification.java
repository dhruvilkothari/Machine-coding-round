import java.time.LocalDateTime;

public class TimeStampNotification extends NotificationDecorator{

    private final Notification notification;
    public TimeStampNotification(Notification notification){
        this.notification = notification;
    }

    @Override
    public String getContent() {
        return this.notification.getContent()+": Timestamp:" + LocalDateTime.now();
    }
}
