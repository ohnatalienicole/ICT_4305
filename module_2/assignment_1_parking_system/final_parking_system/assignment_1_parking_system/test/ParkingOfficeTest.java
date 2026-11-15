
import static org.junit.Assert.*;
import org.junit.Test;

public class ParkingOfficeTest {

    @Test
    public void testCustomerRegistration() {
        ParkingOffice office = new ParkingOffice("University Parking", null);

        Customer customer = office.register(
            "Jane Smith", null, "555-1234"
        );

        assertNotNull(customer);
        assertEquals("Jane Smith", customer.getName());
        assertEquals(1, office.getCustomers().size());
    }

    @Test
    public void testCarRegistration() {
        ParkingOffice office = new ParkingOffice("University Parking", null);

        Customer customer = office.register(
            "Jane Smith", null, "555-1234"
        );

        Car car = office.register(
            customer, "ABC123", CarType.COMPACT
        );

        assertEquals("ABC123", car.getLicense());
        assertEquals("PERMIT-ABC123", car.getPermit());
        assertEquals(1, office.getCars().size());
    }

    @Test
    public void testParkingCharge() {
        ParkingOffice office = new ParkingOffice("University Parking", null);
        ParkingLot lot = new ParkingLot("LOT-A", null, 10);

        office.addParkingLot(lot);

        Customer customer = office.register(
            "Jane Smith", null, "555-1234"
        );

        Car car = office.register(
            customer, "ABC123", CarType.COMPACT
        );

        lot.entry(car);

        assertEquals(1, office.getCharges().size());
        assertEquals(
            4.00,
            office.getCharges().get(0).getAmount().getDollars(),
            0.001
        );
    }

    @Test
    public void testMoneyConversion() {
        Money amount = new Money(500);

        assertEquals(5.00, amount.getDollars(), 0.001);
        assertEquals("$5.00", amount.toString());
    }
}
