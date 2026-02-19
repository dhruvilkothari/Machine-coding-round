public class EmailStrategy implements NotificationStrategy{
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sendng Notifciation Via Email"+ notification.getContent());
    }
}
