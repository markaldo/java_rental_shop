package z02_eng_v2II;

public class VehicleTypeComparator implements java.util.Comparator<Vehicle> {
    public int compare(Vehicle v1, Vehicle v2) {
        String type1 = v1.getClass().getSimpleName();
        String type2 = v2.getClass().getSimpleName();
        return type1.compareTo(type2);
    }
}
