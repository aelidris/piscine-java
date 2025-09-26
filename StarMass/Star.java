import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super();
        this.magnitude = 0.0;
    }

    public Star(String name, double x, double y, double z, double magnitude, int mass) {
        super(name, x, y, z, mass);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Star other = (Star) obj;
        return Double.compare(magnitude, other.magnitude) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.2f magnitude", name, magnitude);
    }
}
