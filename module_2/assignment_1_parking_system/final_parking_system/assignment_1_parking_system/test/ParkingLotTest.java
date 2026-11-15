import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void testCarEntry() {
        Address lotAddress = new Address(
            "2101 E Asbury Ave",
            "",
            "Denver",
            "CO",
            "80210"
        );

        ParkingLot parkingLot = new ParkingLot(
            "LOT001",
            lotAddress,
            100
        );

        Customer customer = new Customer(
            "CUSTOMER001",
            "Taylor Smith",
            lotAddress,
            "303-555-0100"
        );

        Car car = customer.register(
            "ABC123",
            CarType.COMPACT
        );

        parkingLot.entry(car);

        assertEquals(1, parkingLot.getParkedCars().size());
        assertEquals(car, parkingLot.getParkedCars().get(0));
    }
}