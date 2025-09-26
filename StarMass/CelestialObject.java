public class CelestialObject {

    public double x = 0.0;
    public double y = 0.0;
    public double z = 0.0;
    public String name = "Soleil";
    private int mass;
    public static final double KM_IN_ONE_AU = 150000000;

    public CelestialObject() {
        this.mass = 0;
    }

    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
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

    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass())
            return false;

        CelestialObject that = (CelestialObject) obj;

        if (Double.compare(that.x, x) != 0)
            return false;
        if (Double.compare(that.y, y) != 0)
            return false;
        if (Double.compare(that.z, z) != 0)
            return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    public int hashCode() {
        return java.util.Objects.hash(name, x, y, z);
    }
}