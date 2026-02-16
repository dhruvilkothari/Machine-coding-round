package Entity;

public class ParkingLotBoard implements Observers{
    @Override
    public void notifyObserver(String message) {
        System.out.println(" Message: "  + message);
    }
}
