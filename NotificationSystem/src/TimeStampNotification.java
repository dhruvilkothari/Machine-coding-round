import java.time.LocalDateTime;

public class TimeStampNotification extends NotificationDecorator{

    public TimeStampNotification(Notification notification){
        super(notification);

    }

    @Override
    public String getContent() {
        return this.notification.getContent()+": Timestamp:" + LocalDateTime.now();
    }
}
