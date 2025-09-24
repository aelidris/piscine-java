public class CelestialObject {
    public double x = 0.0;
    public double y = 0.0;
    public double z = 0.0;
    public String name = "Soleil";

    public CelestialObject() {
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}