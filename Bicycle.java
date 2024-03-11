package z02_eng_v2II;

class Bicycle extends Vehicle implements Parkable {
    public Bicycle(String name) {
        super(name, 0, 0);
    }

    @Override
    public boolean park(Garage garage) {
        garage.setOccupied(true);
        return garage.getOccupied();
    }

    @Override
    public String toString() {
        return "Bicycle: " + super.getName();
    }
}
