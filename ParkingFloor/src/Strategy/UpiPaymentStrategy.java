package Strategy;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Amount is Being Payed by UPI"+ amount);
    }
}
