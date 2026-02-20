package Entity;


import Entity.Enum.CarType;

public class Car {
    private final Long id;
    private final String name;
    private CarType carType;

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    private int pricePerDay;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Car(Long id, String name, CarType carType, int pricePerDay) {
        this.id = id;
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.carType = carType;
    }
}
