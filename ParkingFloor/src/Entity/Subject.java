package Entity;

public interface Subject {
    public void addObserver(Observers observers);
    public void removeObserver(Observers observers);
    public void notifyObserver();
}
