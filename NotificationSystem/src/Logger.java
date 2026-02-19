public class Logger implements Observer{
    @Override
    public void update(Notification notification) {
        System.out.println(notification.getContent()+ " In Logger Class");
    }
}
