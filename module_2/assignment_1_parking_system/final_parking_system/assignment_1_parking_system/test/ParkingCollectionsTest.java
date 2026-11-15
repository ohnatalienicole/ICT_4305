import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Collection;

public class ParkingCollectionsTest {

    @Test
    public void testGetCustomerIds() {
        ParkingOffice office = new ParkingOffice("University Parking", null);

        Customer customer = office.register("Jane Smith", null, "555-1234");

        Collection<String> ids = office.getCustomerIds();

        assertEquals(1, ids.size());
        assertTrue(ids.contains(customer.getCustomerId()));
    }

    @Test
    public void testGetPermitIds() {
        ParkingOffice office = new ParkingOffice("University Parking", null);

        Customer customer = office.register("Jane Smith", null, "555-1234");

        Car car = office.register(customer, "ABC123", CarType.COMPACT);

        Collection<String> ids = office.getPermitIds();

        assertEquals(1, ids.size());
        assertTrue(ids.contains(car.getPermit()));
    }

    @Test
    public void testGetPermitIdsForCustomer() {
        ParkingOffice office = new ParkingOffice("University Parking", null);

        Customer jane = office.register("Jane Smith", null, "555-1234");
        Customer john = office.register("John Doe", null, "555-5678");

        Car janeCar = office.register(jane, "ABC123", CarType.COMPACT);
        Car johnCar = office.register(john, "XYZ789", CarType.SUV);

        Collection<String> ids = office.getPermitIds(jane);

        assertEquals(1, ids.size());
        assertTrue(ids.contains(janeCar.getPermit()));
        assertFalse(ids.contains(johnCar.getPermit()));
    }

    @Test
    public void testCustomerEquality() {
        Customer first = new Customer("CUST-1", "Jane Smith", null, "555-1234");
        Customer second = new Customer("CUST-1", "Jane Smith", null, "555-1234");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void testMoneyEquality() {
        Money first = new Money(500);
        Money second = new Money(500);

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }
}