public class SimpleNotification extends Notification {
    private String text;

    public SimpleNotification(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }
}
