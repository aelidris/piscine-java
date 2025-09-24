public class CelestialObject {
    public double x = 0.0;
    public double y = 0.0;
    public double z = 0.0;
    public String name = "Soleil";
    public static final double KM_IN_ONE_AU = 150000000;

    public CelestialObject() {
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getName() {
        return name;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }

    public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        double dz = a.z - b.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * KM_IN_ONE_AU;
    }

}