import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centeStar) {
        super(name, x, y, z);
        this.centerStar = centeStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Planet))
            return false;
        if (!super.equals(obj))
            return false;

        Planet other = (Planet) obj;
        return Objects.equals(centerStar, other.centerStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerStar);
    }

    @Override
    public String toString() {
        double distance = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distance);
    }
}