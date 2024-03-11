package z02_eng_v2II;

abstract class Vehicle {
    private static int lastId = 0;
    private int id;
    private String name;
    private int fuelType;
    private int fuelQuantity;
    private Garage garage;

    public Vehicle(String name, int fuelType, int fuelQuantity) {
        this.id = ++lastId;
        this.name = name;
        this.fuelType = fuelType;
        this.fuelQuantity = fuelQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFuelType() {
        return fuelType;
    }

    public int getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(int fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Garage getGarage() {
        return garage;
    }

    public abstract String toString();
}