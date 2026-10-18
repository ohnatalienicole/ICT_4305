
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String lotId;
    private Address address;
    private int capacity;
    private List<Car> parkedCars;
    private ParkingOffice parkingOffice;

    public ParkingLot(String lotId, Address address, int capacity) {
        this.lotId = lotId;
        this.address = address;
        this.capacity = capacity;
        this.parkedCars = new ArrayList<>();
    }

    public String getLotId() {
        return lotId;
    }

    public Address getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkingOffice(ParkingOffice parkingOffice) {
        this.parkingOffice = parkingOffice;
    }

    public void entry(Car car) {
        if (parkedCars.size() < capacity) {
            parkedCars.add(car);

            if (parkingOffice != null) {
                long chargeInCents = 500;

                if (car.getType() == CarType.COMPACT) {
                    chargeInCents = 400;
                }

                Money amount = new Money(chargeInCents);

                ParkingCharge charge = new ParkingCharge(
                    car.getPermit(),
                    lotId,
                    Instant.now(),
                    amount
                );

                parkingOffice.addCharge(charge);
            }
        }
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "lotId='" + lotId + '\'' +
                ", capacity=" + capacity +
                ", parkedCars=" + parkedCars.size() +
                '}';
    }
}
