package z02_eng_v2II;

class Motorboat extends Vehicle implements Refuelable {
    public Motorboat(String name, int fuelType, int fuelQuantity) {
        super(name, fuelType, fuelQuantity);
    }

    @Override
    public boolean refuel(int numOfLiters, int fuelType) {
        if (getFuelType() == fuelType) {
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
    public String toString() {
        return "Motorboat: " + super.getName();
    }
}
