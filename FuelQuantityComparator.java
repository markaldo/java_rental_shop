package z02_eng_v2II;

public class FuelQuantityComparator implements java.util.Comparator<Vehicle> {
    public int compare(Vehicle v1, Vehicle v2) {
        int quantity1 = v1.getFuelQuantity();
        int quantity2 = v2.getFuelQuantity();
        return Integer.compare(quantity1, quantity2);
    }
}
