
import java.util.ArrayList;
import java.util.List;

public class PermitManager {
    private List<ParkingPermit> permits;

    public PermitManager() {
        permits = new ArrayList<>();
    }

    public ParkingPermit register(Car car, String permitId) {
        if (car == null || permitId == null ||
                permitId.isEmpty()) {
            throw new IllegalArgumentException(
                "Car and permit ID are required."
            );
        }

        ParkingPermit permit =
            new ParkingPermit(permitId, car);

        if (permits.contains(permit)) {
            throw new IllegalArgumentException(
                "Permit ID already exists."
            );
        }

        permits.add(permit);
        return permit;
    }

    public ParkingPermit getPermit(String permitId) {
        for (ParkingPermit permit : permits) {
            if (permit.getPermitId().equals(permitId)) {
                return permit;
            }
        }
        return null;
    }

    public List<ParkingPermit> getPermits() {
        return new ArrayList<>(permits);
    }
}
