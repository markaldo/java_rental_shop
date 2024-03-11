package z02_eng_v2II;

interface Refuelable {
    boolean refuel(int fuelType, int quantity);
    int getFuelType();
}