package z02_eng_v2II;

public class FuelTypeComparator implements java.util.Comparator<Vehicle> {
    public int compare(Vehicle v1, Vehicle v2) {
        int type1 = v1.getFuelType();
        int type2 = v2.getFuelType();
        return Integer.compare(type1, type2);
    }
}
