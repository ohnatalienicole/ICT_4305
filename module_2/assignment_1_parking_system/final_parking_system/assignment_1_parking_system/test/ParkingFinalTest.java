import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ParkingFinalTest {

    @Test
    public void testParkingOfficeName() {
        ParkingOffice office = new ParkingOffice("Main Parking Office", null);

        assertEquals("Main Parking Office", office.getParkingOfficeName());
    }

    @Test
    public void testMoneyCents() {
        Money amount = new Money(500);

        assertEquals(500L, amount.getCents());
        assertEquals(5.00, amount.getDollars(), 0.001);
    }

    @Test
    public void testMoneyEquality() {
        Money first = new Money(500);
        Money second = new Money(500);

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void testPermitManagerStartsEmpty() {
        PermitManager manager = new PermitManager();

        assertTrue(manager.getPermits().isEmpty());
        assertNull(manager.getPermit("UNKNOWN"));
    }

    @Test
    public void testTransactionManagerStartsEmpty() {
        TransactionManager manager = new TransactionManager();

        assertTrue(manager.getTransactions().isEmpty());
    }

    @Test
    public void testInvalidParkingTransaction() {
        TransactionManager manager = new TransactionManager();

        assertThrows(
            IllegalArgumentException.class,
            () -> manager.park(new Date(), null, null, new Money(500))
        );
    }
}