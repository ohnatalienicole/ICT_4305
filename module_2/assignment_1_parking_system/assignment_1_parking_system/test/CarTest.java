import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.time.LocalDate;

public class CarTest {

    @Test
    public void testCarInformation() {
        LocalDate expiration = LocalDate.of(2027, 10, 4);

        Car car = new Car(
            "PERMIT001",
            expiration,
            "ABC123",
            CarType.COMPACT,
            "CUSTOMER001"
        );

        assertEquals("PERMIT001", car.getPermit());
        assertEquals(expiration, car.getPermitExpiration());
        assertEquals("ABC123", car.getLicense());
        assertEquals(CarType.COMPACT, car.getType());
        assertEquals("CUSTOMER001", car.getOwner());
    }
}
