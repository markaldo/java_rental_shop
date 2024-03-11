package z02_eng_v2II;

class Car extends Vehicle implements Refuelable, Parkable {
    private static final int DIESEL = 1;
    private static final int GASOLINE = 2;
    private static final int LPG = 4;
    private static final int CNG = 8;

    public Car(String name, int fuelType, int fuelQuantity) {
        super(name, fuelType, fuelQuantity);
    }

    @Override
    public boolean refuel(int numOfLiters, int fuelType) {
        if ((getFuelType() & fuelType) == fuelType) {
            setFuelQuantity(getFuelQuantity() + numOfLiters);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getFuelType() {
        return super.getFuelType();
    }

    @Override
    public boolean park(Garage garage) {
        garage.setOccupied(true);
        return garage.getOccupied();
    }

    @Override
    public String toString() {
        return "Car: " + super.getName();
    }
}    
