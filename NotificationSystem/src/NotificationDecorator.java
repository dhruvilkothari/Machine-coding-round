public abstract class NotificationDecorator extends Notification {

    protected Notification notification;

    public NotificationDecorator(Notification notification){
        this.notification = notification;
    }

    @Override
    public String getContent(){
        return notification.getContent();
    }
}
