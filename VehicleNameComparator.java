package z02_eng_v2II;

public class VehicleNameComparator implements java.util.Comparator<Vehicle> {
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getName().compareTo(v2.getName());
    }
}
