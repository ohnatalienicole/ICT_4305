
import java.util.Objects;

public class ParkingPermit {
    private String permitId;
    private Car car;

    public ParkingPermit(String permitId, Car car) {
        this.permitId = permitId;
        this.car = car;
    }

    public String getPermitId() {
        return permitId;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParkingPermit)) return false;

        ParkingPermit other = (ParkingPermit) obj;
        return Objects.equals(permitId, other.permitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permitId);
    }
}
