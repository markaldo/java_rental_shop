package z02_eng_v2II;

public class ParkedComparator implements java.util.Comparator<Vehicle> {
    public int compare(Vehicle v1, Vehicle v2) {
        if (v1.getGarage() == null && v2.getGarage() != null) {
            return 1;
        } else if (v1.getGarage() != null && v2.getGarage() == null) {
            return -1;
        } else {
            return 0;
        }
    }
}
