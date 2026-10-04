import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testRegisterCar() {
        Address address = new Address(
            "2199 S University Blvd",
            "",
            "Denver",
            "CO",
            "80208"
        );

        Customer customer = new Customer(
            "CUSTOMER001",
            "Taylor Smith",
            address,
            "303-555-0100"
        );

        Car car = customer.register("ABC123", CarType.COMPACT);

        assertNotNull(car);
        assertEquals("ABC123", car.getLicense());
        assertEquals(CarType.COMPACT, car.getType());
        assertEquals("CUSTOMER001", car.getOwner());
    }
}
